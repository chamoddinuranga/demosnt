package com.example.demo.repo;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByProductName(String productName);
    Optional<Product> findByProductName(String productName);
    void deleteByProductName(String productName);
    List<Product> findByProductNameContainingIgnoreCase(String query);

}

