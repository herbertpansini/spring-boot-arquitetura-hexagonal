package com.example.sampleapi.adapters.inbound.controller;

import com.example.sampleapi.adapters.dtos.CategoryDto;
import com.example.sampleapi.application.domain.PageInfo;
import com.example.sampleapi.application.ports.service.CategoryServicePort;
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
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryServicePort categoryServicePort;

    @GetMapping
    @Timed
    public ResponseEntity<Page<CategoryDto>> findAll(Pageable pageable){
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<CategoryDto> categoryListDto = this.categoryServicePort.findAll(pageInfo);
        return new ResponseEntity<>(new PageImpl<CategoryDto>(categoryListDto, pageable, categoryListDto.size()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Timed
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoryServicePort.findById(id));
    }

    @PostMapping
    @Timed
    public ResponseEntity<CategoryDto> save(@Valid @RequestBody CategoryDto categoryDto) {
        return new ResponseEntity(this.categoryServicePort.save(categoryDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @Timed
    public ResponseEntity<CategoryDto> update(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(this.categoryServicePort.update(id, categoryDto));
    }

    @DeleteMapping("{id}")
    @Timed
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.categoryServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
