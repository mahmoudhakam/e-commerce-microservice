package com.carbon.customerservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@Setter
@Getter
@RefreshScope
public class RefreshScopedService {

    @Value("${app.customer.boolean}")
    private boolean testRefresh;

    String responseMessage;

    //    @PostConstruct
    public String refresh() {

        responseMessage = responseMessage = "Service is running with tps: " + testRefresh;
        return responseMessage;
    }

}
