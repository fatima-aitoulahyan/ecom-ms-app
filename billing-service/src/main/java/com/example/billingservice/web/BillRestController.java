package com.example.billingservice.web;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.feign.CustomerServiceRestCient;
import com.example.billingservice.feign.InventoryServiceRestClient;
import com.example.billingservice.repository.BillRespository;
import com.example.billingservice.repository.ProductItemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BillRestController {
    private BillRespository billRespository;
    private ProductItemRepository productItemRepository;
    private CustomerServiceRestCient customerServiceRestCient;
    private InventoryServiceRestClient inventoryServiceRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id)
    {
        Bill bill = billRespository.findById(id).orElse(null);
        bill.setCustomer(customerServiceRestCient.findCustomerById(bill.getCustomerId()));
        return bill;
    }
}
