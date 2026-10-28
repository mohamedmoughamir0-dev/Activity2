package com.example.inventoryservice.repository;

import com.example.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository <Product, Long> {

}