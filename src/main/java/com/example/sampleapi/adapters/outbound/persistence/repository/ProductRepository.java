package com.example.sampleapi.adapters.outbound.persistence.repository;

import com.example.sampleapi.adapters.outbound.persistence.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}