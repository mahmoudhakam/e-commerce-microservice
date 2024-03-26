package com.carbon.customerservice.customer;

import com.carbon.customerservice.customer.exceptions.CustomerNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Mono<Customer> get(String id) {

        return customerRepository.findById(id)
                .switchIfEmpty(Mono.error(new CustomerNotFound(id)));
    }

}
