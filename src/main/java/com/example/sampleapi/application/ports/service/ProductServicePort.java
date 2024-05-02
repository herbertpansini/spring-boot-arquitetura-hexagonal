package com.example.sampleapi.application.ports.service;

import com.example.sampleapi.adapters.dtos.ProductDto;
import com.example.sampleapi.application.domain.PageInfo;

import java.util.List;

public interface ProductServicePort {
    List<ProductDto> findAll(PageInfo pageInfo);
    ProductDto findById(Long id);
    ProductDto save(ProductDto productDto);
    ProductDto update(Long id, ProductDto productDto);
    void deleteById(Long id);
}