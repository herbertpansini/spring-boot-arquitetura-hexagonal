package com.example.sampleapi.adapters.outbound.persistence.repository.impl;

import com.example.sampleapi.adapters.outbound.persistence.model.CategoryModel;
import com.example.sampleapi.adapters.outbound.persistence.repository.CategoryRepository;
import com.example.sampleapi.application.domain.Category;
import com.example.sampleapi.application.domain.PageInfo;
import com.example.sampleapi.application.ports.repository.CategoryRepositoryPort;
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
public class CategoryRepositoryImpl implements CategoryRepositoryPort {

    private final CategoryRepository categoryRepository;

    public CategoryRepositoryImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Category> findAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return this.categoryRepository.findAll(pageable).stream().map(entity -> modelMapper.map(entity, Category.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById(Long id) {
        return this.categoryRepository.findById(id).map(entity -> modelMapper.map(entity, Category.class));
    }

    @Override
    public Category save(Category category) {
        return modelMapper.map(this.categoryRepository.save(modelMapper.map(category, CategoryModel.class)), Category.class);
    }

    @Override
    public void deleteById(Long id) {
        this.categoryRepository.deleteById(id);
    }
}