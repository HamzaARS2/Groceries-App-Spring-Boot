package com.example.groceriesapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products") 
public class Product {
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
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discount_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Discount discount;

}
