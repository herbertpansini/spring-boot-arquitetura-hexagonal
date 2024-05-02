package com.example.sampleapi.adapters.outbound.persistence.repository;

import com.example.sampleapi.adapters.outbound.persistence.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<CategoryModel, Long> {
}