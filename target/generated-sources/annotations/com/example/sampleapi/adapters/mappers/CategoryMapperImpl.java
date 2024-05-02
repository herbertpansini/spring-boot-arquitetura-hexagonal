package com.example.sampleapi.adapters.mappers;

import com.example.sampleapi.adapters.dtos.CategoryDto;
import com.example.sampleapi.application.domain.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-02T16:40:38-0300",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( dto.getId() );
        category.setName( dto.getName() );
        category.setDescription( dto.getDescription() );

        return category;
    }

    @Override
    public CategoryDto toDto(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setDescription( entity.getDescription() );
        categoryDto.setId( entity.getId() );
        categoryDto.setName( entity.getName() );

        return categoryDto;
    }

    @Override
    public List<Category> toEntity(List<CategoryDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( dtoList.size() );
        for ( CategoryDto categoryDto : dtoList ) {
            list.add( toEntity( categoryDto ) );
        }

        return list;
    }

    @Override
    public List<CategoryDto> toDto(List<Category> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( entityList.size() );
        for ( Category category : entityList ) {
            list.add( toDto( category ) );
        }

        return list;
    }
}
