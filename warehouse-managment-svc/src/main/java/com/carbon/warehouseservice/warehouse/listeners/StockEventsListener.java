package com.carbon.warehouseservice.warehouse.listeners;

import com.carbon.warehouseservice.notification.NotificationService;
import com.carbon.warehouseservice.warehouse.WarehouseService;
import com.carbon.warehouseservice.warehouse.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import static com.carbon.warehouseservice.configs.KafkaConfig.WAREHOUSE_STOCK_RELEASE_TOPIC;
import static com.carbon.warehouseservice.configs.KafkaConfig.WAREHOUSE_STOCK_RESERVE_TOPIC;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockEventsListener {

    private final WarehouseService warehouseService;

    private final NotificationService notificationService;

    @KafkaListener(topics = WAREHOUSE_STOCK_RESERVE_TOPIC)
    public void reserveStock(@Payload Object event) {

        var order = (Order) event;
        log.info("received stock reservation event for order {}", order.getId());
        Flux.fromIterable(order.getOrderLines())
                .flatMap(warehouseService::verifyIsInStock)
                .thenMany(Flux.fromIterable(order.getOrderLines()))
                .doOnNext(warehouseService::reserveStock)
                .onErrorStop()
                .doOnError(error -> warehouseService.rejectStockReservation(order.getId(), error.getMessage()))
                .doOnError(error -> notificationService.informCustomerAboutCancellation(order.getCustomerId(), order.getId(), error.getMessage()))
                .doOnComplete(() -> warehouseService.confirmStockReservation(order.getId()))
                .subscribe();
    }

    @KafkaListener(topics = WAREHOUSE_STOCK_RELEASE_TOPIC)
    public void releaseStock(@Payload Object event) {

        var order = (Order) event;
        log.info("received stock release event for order {}", order.getId());
        Flux.fromIterable(order.getOrderLines())
                .flatMap(warehouseService::clearStockReservation)
                .subscribe();
    }

}
