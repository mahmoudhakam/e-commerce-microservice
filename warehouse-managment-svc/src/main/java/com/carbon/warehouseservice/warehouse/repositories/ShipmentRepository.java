package com.carbon.warehouseservice.warehouse.repositories;

import com.carbon.warehouseservice.warehouse.domain.Shipment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ShipmentRepository extends ReactiveMongoRepository<Shipment, String> {

}
