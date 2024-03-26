package com.hakam.orderservice.order;

import com.hakam.orderservice.order.domain.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

interface OrderRepository extends ReactiveMongoRepository<Order, String> {

}
