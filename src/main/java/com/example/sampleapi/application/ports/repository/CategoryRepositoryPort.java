package com.example.sampleapi.application.ports.repository;

import com.example.sampleapi.application.domain.Category;
import com.example.sampleapi.application.domain.PageInfo;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {
    List<Category> findAll(PageInfo pageInfo);
    Optional<Category> findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
}