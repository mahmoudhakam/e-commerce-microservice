package com.carbon.warehouseservice.warehouse.repositories;

import com.carbon.warehouseservice.warehouse.domain.StockLine;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StockLineRepository extends ReactiveMongoRepository<StockLine, String> {

}
