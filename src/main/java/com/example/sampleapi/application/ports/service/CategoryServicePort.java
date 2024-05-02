package com.example.sampleapi.application.ports.service;

import com.example.sampleapi.adapters.dtos.CategoryDto;
import com.example.sampleapi.application.domain.PageInfo;

import java.util.List;

public interface CategoryServicePort {
    List<CategoryDto> findAll(PageInfo pageInfo);
    CategoryDto findById(Long id);
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto update(Long id, CategoryDto categoryDto);
    void deleteById(Long id);
}
