package com.carbon.financeservice.finance;

import com.carbon.financeservice.finance.domain.Invoice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface InvoiceRepository extends ReactiveMongoRepository<Invoice, String> {

}
