package com.example.sampleapi.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String name;
    private String description;
}
