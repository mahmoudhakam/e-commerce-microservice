//package com.carbon.customerservice;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyRefreshListener implements ApplicationListener<EnvironmentChangeEvent> {
//
//    @Autowired
//    RefreshScopedService refreshScopedService;
//
//    @Override
//    public void onApplicationEvent(EnvironmentChangeEvent event) {
//
////        if (event.getKeys().contains("app.customer.boolean")) {
////            refreshScopedService.refresh();
////        }
//    }
//
//}
