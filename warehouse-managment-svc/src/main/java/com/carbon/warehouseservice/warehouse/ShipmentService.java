package com.carbon.warehouseservice.warehouse;

import com.carbon.warehouseservice.warehouse.domain.Order;
import com.carbon.warehouseservice.warehouse.domain.Shipment;
import com.carbon.warehouseservice.warehouse.repositories.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public Mono<Shipment> prepare(Order order) {

        return shipmentRepository.save(order.toShipment());
    }

}
