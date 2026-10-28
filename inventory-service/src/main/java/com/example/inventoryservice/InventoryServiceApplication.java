package com.example.inventoryservice;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repository.ProductRepository;
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
            productRepository.save(Product.builder()
                    .name("phone")
                    .price(30000)
                    .quantity(10)
                    .build());
            productRepository.save(Product.builder()
                    .name("laptop")
                    .price(80980)
                    .quantity(27)
                    .build());
            productRepository.save(Product.builder()
                    .name("dvd")
                    .price(15000)
                    .quantity(8)
                    .build());
        };
    }
}
