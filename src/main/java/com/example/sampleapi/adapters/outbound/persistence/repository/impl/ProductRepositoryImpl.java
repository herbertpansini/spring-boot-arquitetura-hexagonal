package com.example.sampleapi.adapters.outbound.persistence.repository.impl;

import com.example.sampleapi.adapters.outbound.persistence.model.ProductModel;
import com.example.sampleapi.adapters.outbound.persistence.repository.ProductRepository;
import com.example.sampleapi.application.domain.PageInfo;
import com.example.sampleapi.application.domain.Product;
import com.example.sampleapi.application.ports.repository.ProductRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Primary
public class ProductRepositoryImpl implements ProductRepositoryPort {

    private final ProductRepository productRepository;

    public ProductRepositoryImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Product> findAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return this.productRepository.findAll(pageable).stream().map(entity -> modelMapper.map(entity, Product.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id).map(entity -> modelMapper.map(entity, Product.class));
    }

    @Override
    public Product save(Product product) {
        return modelMapper.map(this.productRepository.save(modelMapper.map(product, ProductModel.class)), Product.class);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}