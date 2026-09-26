package com.example.billingservice;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.repository.BillRespository;
import com.example.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BillRespository billRespository , ProductItemRepository productItemRepo){
        return (args -> {
            List<Long> customersIds = List.of(1L,2L,3L);
            List<Long> productsIds = List.of(1L,2L,3L);
            customersIds.forEach(clientId->{
                Bill bill = new Bill();
                bill.setBillingdate(new Date());
                bill.setCustomerId(clientId);
                billRespository.save(bill);
                productsIds.forEach(productId->{
                    ProductItem productItem = new ProductItem();
                    productItem.setPrice(1000*Math.random()*600);
                    productItem.setQuantity(1+new Random().nextInt(20));
                    productItem.setProductId(productId);
                    productItem.setBill(bill);
                    productItemRepo.save(productItem);
                });

            });

        });

    }
}
