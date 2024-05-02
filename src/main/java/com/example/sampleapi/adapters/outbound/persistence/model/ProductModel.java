package com.example.sampleapi.adapters.outbound.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "products")
@Data
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private CategoryModel category;

    @Column(name = "quantity_per_unit", nullable = true)
    private String quantityPerUnit;

    @Column(name = "unit_price", nullable = true)
    private Double unitPrice;

    @Column(name = "units_in_stock", nullable = true)
    private Integer unitsInStock;

    @Column(name = "units_on_order", nullable = true)
    private Integer unitsOnOrder;

    @Column(name = "reorder_level", nullable = true)
    private Integer reorderLevel;

    @Column(name = "discontinued", nullable = false)
    private Boolean discontinued;
}