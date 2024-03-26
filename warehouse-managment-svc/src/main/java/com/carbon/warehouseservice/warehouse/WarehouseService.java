package com.carbon.warehouseservice.warehouse;

import com.carbon.warehouseservice.warehouse.clients.OrderServiceClient;
import com.carbon.warehouseservice.warehouse.domain.OrderLine;
import com.carbon.warehouseservice.warehouse.domain.StockLine;
import com.carbon.warehouseservice.warehouse.exceptions.ItemNotFound;
import com.carbon.warehouseservice.warehouse.exceptions.ItemNotInStock;
import com.carbon.warehouseservice.warehouse.repositories.StockLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final StockLineRepository stockLineRepository;

    private final OrderServiceClient orderServiceClient;

    public Mono<Void> verifyIsInStock(OrderLine orderLine) {

        var itemId = orderLine.getItemId();
        var quantity = orderLine.getQuantity();
        return stockLineRepository.findById(itemId)
                .switchIfEmpty(Mono.error(new ItemNotFound(itemId)))
                .flatMap(sl -> sl.getAmountAvailable() >= quantity ? Mono.empty() : Mono.error(new ItemNotInStock(itemId, sl.getAmountAvailable(), quantity)));
    }

    public Mono<StockLine> reserveStock(OrderLine orderLine) {

        var itemId = orderLine.getItemId();
        var quantity = orderLine.getQuantity();
        return stockLineRepository.findById(itemId)
                .map(sl -> sl.reserve(quantity))
                .flatMap(stockLineRepository::save);
    }

    public Mono<StockLine> clearStockReservation(OrderLine orderLine) {

        var itemId = orderLine.getItemId();
        var quantity = orderLine.getQuantity();
        return stockLineRepository.findById(itemId)
                .map(sl -> sl.clearReservation(quantity))
                .flatMap(stockLineRepository::save);
    }

    public void rejectStockReservation(String orderId, String message) {

        orderServiceClient.sendStockReservationFailure(orderId, message);
    }

    public void confirmStockReservation(String orderId) {

        orderServiceClient.sendStockReservationSuccess(orderId);
    }

}
