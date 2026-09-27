package com.example.billingservice.feign;

import com.example.billingservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiceRestCient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customer-service" , fallbackMethod = "CustomerFallBack")
    Customer findCustomerById(@PathVariable Long id);
    default Customer CustomerFallBack(Long id , Throwable e){
        Customer customer= new Customer();
        customer.setId(id);
        customer.setName("Not found");
        customer.setEmail("not Found ");
        return customer;
    }
}
