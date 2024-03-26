package com.customerservice.customer;

import com.customerservice.RefreshScopedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    private final RefreshScopedService refreshScopedService;

    @GetMapping("/{id}")
    public Mono<Customer> getOne(@PathVariable String id) {

        return customerService.get(id);
    }

    @GetMapping("/refresh")
    public String refresh() {

        return refreshScopedService.refresh();
    }

}
