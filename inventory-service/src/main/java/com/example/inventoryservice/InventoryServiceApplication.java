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
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {

            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(5000)
                    .quantity(10)
                    .build());

            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1500)
                    .quantity(5)
                    .build());

            productRepository.save(Product.builder()
                    .name("Smartphone")
                    .price(3000)
                    .quantity(20)
                    .build());

            productRepository.save(Product.builder()
                    .name("Keyboard")
                    .price(250)
                    .quantity(15)
                    .build());
        };
    }
}
