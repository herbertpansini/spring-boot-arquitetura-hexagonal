package com.example.sampleapi.adapters.mappers;

import com.example.sampleapi.adapters.dtos.ProductDto;
import com.example.sampleapi.application.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper extends EntityMapper<ProductDto, Product> {
}