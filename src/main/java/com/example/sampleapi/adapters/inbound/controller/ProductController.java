package com.example.sampleapi.adapters.inbound.controller;

import com.example.sampleapi.adapters.dtos.ProductDto;
import com.example.sampleapi.application.domain.PageInfo;
import com.example.sampleapi.application.ports.service.ProductServicePort;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductServicePort productServicePort;

    @GetMapping
    @Timed
    public ResponseEntity<Page<ProductDto>> findAll(Pageable pageable){
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<ProductDto> productListDto = this.productServicePort.findAll(pageInfo);
        return new ResponseEntity<>(new PageImpl<ProductDto>(productListDto, pageable, productListDto.size()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Timed
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productServicePort.findById(id));
    }

    @PostMapping
    @Timed
    public ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity(productServicePort.save(productDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @Timed
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productServicePort.update(id, productDto));
    }

    @DeleteMapping("{id}")
    @Timed
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.productServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}