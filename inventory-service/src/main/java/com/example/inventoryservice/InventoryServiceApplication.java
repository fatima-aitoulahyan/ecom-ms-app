package com.example.inventoryservice;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repostitory.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product
                    .builder()
                            .name("Computer")
                            .price(3400)
                            .quantity(12)
                    .build());
            productRepository.save(Product
                    .builder()
                    .name("smart phone")
                    .price(300)
                    .quantity(10)
                    .build());
            productRepository.save(Product
                    .builder()
                    .name("printer")
                    .price(34000)
                    .quantity(2)
                    .build());

        };
    }

}
