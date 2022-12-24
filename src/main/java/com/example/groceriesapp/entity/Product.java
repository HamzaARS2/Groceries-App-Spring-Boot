package com.example.groceriesapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue
    private Integer id;
    @NonNull
    @Column(name = "category_id",insertable=false, updatable=false)
    private Integer categoryId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private BigDecimal price;
    @NonNull
    private Integer quantity;

}
