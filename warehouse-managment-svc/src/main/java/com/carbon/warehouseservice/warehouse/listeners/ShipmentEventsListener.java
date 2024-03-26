package com.carbon.warehouseservice.warehouse.listeners;

import com.carbon.warehouseservice.notification.NotificationService;
import com.carbon.warehouseservice.warehouse.ShipmentService;
import com.carbon.warehouseservice.warehouse.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.carbon.warehouseservice.common.configs.KafkaConfig.WAREHOUSE_SHIPMENT_DISPATCH_TOPIC;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShipmentEventsListener {

    private final ShipmentService shipmentService;

    private final NotificationService notificationService;

    @KafkaListener(topics = WAREHOUSE_SHIPMENT_DISPATCH_TOPIC)
    public void dispatch(@Payload Object event) {

        var order = (Order) event;
        log.info("received shipment dispatch event for order {}", order.getId());
        shipmentService.prepare(order)
                .doOnNext(notificationService::informCustomerAboutShipment)
                .subscribe();
    }

}
