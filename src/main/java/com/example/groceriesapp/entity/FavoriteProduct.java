package com.example.groceriesapp.entity;

import com.example.groceriesapp.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favorite_products")
public class FavoriteProduct {
    @Id @GeneratedValue
    private Integer id;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "created_at")
    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @OneToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id", insertable = false, updatable = false)
    private ProductDetails productDetails;
}
