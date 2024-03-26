package com.carbon.notificationservice.notification.listeners;

import com.carbon.notificationservice.notification.NotificationService;
import com.carbon.notificationservice.notification.domain.Invoice;
import com.carbon.notificationservice.notification.domain.Shipment;
import com.carbon.notificationservice.notification.listeners.events.OrderCancellationEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderEventsListenerTest {

    @Mock
    NotificationService notificationService;

    @InjectMocks
    OrderEventsListener orderEventsListener;

    String orderId = "order-1";

    String customerId = "customer-1";

    @Test
    void notifyAboutCancellation() {

        var event = new OrderCancellationEvent(orderId, customerId, "error");

        doAnswer(inv -> Mono.empty()).when(notificationService).notifyAboutCancellation(anyString(), anyString(), anyString());

        orderEventsListener.notifyAboutCancellation(event);

        verify(notificationService, timeout(500)).notifyAboutCancellation(customerId, orderId, "error");
    }

    @Test
    void notifyAboutShipping() {

        var shipment = Shipment.builder().build();

        doAnswer(inv -> Mono.empty()).when(notificationService).notifyAboutShipping(any());

        orderEventsListener.notifyAboutShipping(shipment);

        verify(notificationService, timeout(500)).notifyAboutShipping(shipment);
    }

    @Test
    void notifyAboutPayment() {

        var invoice = Invoice.builder().build();

        doAnswer(inv -> Mono.empty()).when(notificationService).notifyAboutPayment(any());

        orderEventsListener.notifyAboutPayment(invoice);

        verify(notificationService, timeout(500)).notifyAboutPayment(invoice);
    }

}