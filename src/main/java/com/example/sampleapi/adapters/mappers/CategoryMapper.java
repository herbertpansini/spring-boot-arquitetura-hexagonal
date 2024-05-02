package com.example.sampleapi.adapters.mappers;

import com.example.sampleapi.adapters.dtos.CategoryDto;
import com.example.sampleapi.application.domain.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDto, Category> {
}