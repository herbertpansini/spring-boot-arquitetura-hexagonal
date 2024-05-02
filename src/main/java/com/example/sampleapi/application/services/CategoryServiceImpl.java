package com.example.sampleapi.application.services;

import com.example.sampleapi.adapters.dtos.CategoryDto;
import com.example.sampleapi.adapters.mappers.CategoryMapper;
import com.example.sampleapi.application.domain.PageInfo;
import com.example.sampleapi.application.ports.repository.CategoryRepositoryPort;
import com.example.sampleapi.application.ports.service.CategoryServicePort;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryServicePort {

    private final CategoryRepositoryPort categoryRepositoryPort;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(final CategoryRepositoryPort categoryRepositoryPort,
                               final CategoryMapper categoryMapper) {
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> findAll(PageInfo pageInfo) {
        return this.categoryRepositoryPort.findAll(pageInfo).stream().map(this.categoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        return this.categoryMapper.toDto(this.categoryRepositoryPort.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("Categoria %d não encontrada", id))) );
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return this.categoryMapper.toDto(this.categoryRepositoryPort.save(this.categoryMapper.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        CategoryDto categoryUpdate = this.findById(id);
        BeanUtils.copyProperties(categoryDto, categoryUpdate, "id");
        return this.save(categoryUpdate);
    }

    @Override
    public void deleteById(Long id) {
        this.categoryRepositoryPort.deleteById(id);
    }
}