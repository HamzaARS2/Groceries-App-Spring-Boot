package com.example.groceriesapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products") 
public class ProductDetails {
    @Id @GeneratedValue
    private Integer id;
    @NonNull
    @Column(name = "category_id")
    private Integer categoryId;
    @NonNull
    private String name;
    private String description;
    @NonNull
    private BigDecimal price;
    private String priceUnit;
    private String nutrition;
    private String image;
    @Column(name = "discount_id")
    private Integer discountId;
    @Column(name = "is_exclusive")
    private boolean isExclusive;
    private float rating;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discount_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Discount discount;

}
