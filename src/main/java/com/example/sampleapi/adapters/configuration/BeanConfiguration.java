package com.example.sampleapi.adapters.configuration;

import com.example.sampleapi.SampleApiApplication;
import com.example.sampleapi.adapters.mappers.CategoryMapper;
import com.example.sampleapi.adapters.mappers.ProductMapper;
import com.example.sampleapi.application.ports.repository.CategoryRepositoryPort;
import com.example.sampleapi.application.ports.repository.ProductRepositoryPort;
import com.example.sampleapi.application.services.CategoryServiceImpl;
import com.example.sampleapi.application.services.ProductServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SampleApiApplication.class)
public class BeanConfiguration {

    @Bean
    CategoryServiceImpl categoryServiceImpl(CategoryRepositoryPort categoryRepositoryPort, CategoryMapper categoryMapper) {
        return new CategoryServiceImpl(categoryRepositoryPort, categoryMapper);
    }

    @Bean
    ProductServiceImpl productServiceImpl(ProductRepositoryPort productRepositoryPort, ProductMapper productMapper) {
        return new ProductServiceImpl(productRepositoryPort, productMapper);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

