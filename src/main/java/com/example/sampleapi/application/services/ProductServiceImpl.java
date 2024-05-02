package com.example.sampleapi.application.services;

import com.example.sampleapi.adapters.dtos.ProductDto;
import com.example.sampleapi.adapters.mappers.ProductMapper;
import com.example.sampleapi.application.domain.PageInfo;
import com.example.sampleapi.application.ports.repository.ProductRepositoryPort;
import com.example.sampleapi.application.ports.service.ProductServicePort;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;
    private final ProductMapper productMapper;

    public ProductServiceImpl(final ProductRepositoryPort productRepositoryPort,
                              final ProductMapper productMapper) {
        this.productRepositoryPort = productRepositoryPort;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> findAll(PageInfo pageInfo) {
        return this.productRepositoryPort.findAll(pageInfo).stream().map(this.productMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        return this.productMapper.toDto(this.productRepositoryPort.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("Produto %d não encontrado", id))) );
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return this.productMapper.toDto(this.productRepositoryPort.save(this.productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        ProductDto productUpdate = this.findById(id);
        BeanUtils.copyProperties(productDto, productUpdate, "id");
        return this.save(productUpdate);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepositoryPort.deleteById(id);
    }
}