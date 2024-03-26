package com.carbon.financeservice.notification;

import com.carbon.financeservice.finance.domain.Invoice;
import com.carbon.financeservice.notification.clients.NotificationServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationServiceClient notificationServiceClient;

    public void informCustomerAboutCancellation(String customerId, String orderId, String message) {

        notificationServiceClient.sendOrderCancellationEvent(customerId, orderId, message);
    }

    public void informCustomerAboutPayment(Invoice invoice) {

        notificationServiceClient.sendPaymentSuccessEvent(invoice);
    }

}
