package com.example.groceriesapp.repository;

import com.example.groceriesapp.dto.ProductDto;
import com.example.groceriesapp.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductDetails,Integer> {


    @Query("SELECT new com.example.groceriesapp.dto.ProductDto" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image) " +
            "FROM ProductDetails p ")
    List<ProductDto> findAllProducts();
    @Query("SELECT new com.example.groceriesapp.dto.ProductDto" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image) " +
            "FROM ProductDetails p " +
            "WHERE p.isExclusive = true")
    List<ProductDto> findByIsExclusiveIsTrue();

    @Query("SELECT new com.example.groceriesapp.dto.ProductDto" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image)" +
            " FROM ProductDetails p ORDER BY p.rating DESC LIMIT 2")
    List<ProductDto> findByMostRated();

    @Query("SELECT new com.example.groceriesapp.dto.ProductDto" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image)" +
            " FROM ProductDetails p WHERE p.name LIKE %:query%")
    List<ProductDto> findByNameContaining(String query);

}
