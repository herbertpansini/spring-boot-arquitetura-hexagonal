package com.example.sampleapi.adapters.mappers;

import com.example.sampleapi.adapters.dtos.ProductDto;
import com.example.sampleapi.application.domain.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-02T16:40:38-0300",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Product toEntity(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setName( dto.getName() );
        product.setCategory( categoryMapper.toEntity( dto.getCategory() ) );
        product.setQuantityPerUnit( dto.getQuantityPerUnit() );
        product.setUnitPrice( dto.getUnitPrice() );
        product.setUnitsInStock( dto.getUnitsInStock() );
        product.setUnitsOnOrder( dto.getUnitsOnOrder() );
        product.setReorderLevel( dto.getReorderLevel() );
        product.setDiscontinued( dto.getDiscontinued() );

        return product;
    }

    @Override
    public ProductDto toDto(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setCategory( categoryMapper.toDto( entity.getCategory() ) );
        productDto.setDiscontinued( entity.getDiscontinued() );
        productDto.setId( entity.getId() );
        productDto.setName( entity.getName() );
        productDto.setQuantityPerUnit( entity.getQuantityPerUnit() );
        productDto.setReorderLevel( entity.getReorderLevel() );
        productDto.setUnitPrice( entity.getUnitPrice() );
        productDto.setUnitsInStock( entity.getUnitsInStock() );
        productDto.setUnitsOnOrder( entity.getUnitsOnOrder() );

        return productDto;
    }

    @Override
    public List<Product> toEntity(List<ProductDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( dtoList.size() );
        for ( ProductDto productDto : dtoList ) {
            list.add( toEntity( productDto ) );
        }

        return list;
    }

    @Override
    public List<ProductDto> toDto(List<Product> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( entityList.size() );
        for ( Product product : entityList ) {
            list.add( toDto( product ) );
        }

        return list;
    }
}
