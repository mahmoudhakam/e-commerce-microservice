package com.carbon.notificationservice.notification;

import com.carbon.notificationservice.notification.clients.CustomerServiceClient;
import com.carbon.notificationservice.notification.domain.Invoice;
import com.carbon.notificationservice.notification.domain.Shipment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final CustomerServiceClient customerServiceClient;

    public Mono<Void> notifyAboutCancellation(String customerId, String orderId, String message) {

        return Mono.empty();
    }

    public Mono<Void> notifyAboutShipping(Shipment shipment) {

        return Mono.empty();
    }

    public Mono<Void> notifyAboutPayment(Invoice invoice) {

        return Mono.empty();
    }

}
