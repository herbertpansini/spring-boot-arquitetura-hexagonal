package com.example.sampleapi.application.ports.repository;

import com.example.sampleapi.application.domain.PageInfo;
import com.example.sampleapi.application.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    List<Product> findAll(PageInfo pageInfo);
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
