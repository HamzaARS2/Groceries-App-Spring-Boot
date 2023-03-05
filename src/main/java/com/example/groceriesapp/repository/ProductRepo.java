package com.example.groceriesapp.repository;

import com.example.groceriesapp.dto.ProductDTO;
import com.example.groceriesapp.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductDetails,Integer> {


    @Query("SELECT new com.example.groceriesapp.dto.ProductDTO" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image) " +
            "FROM ProductDetails p ")
    List<ProductDTO> findAllProducts();
    @Query("SELECT new com.example.groceriesapp.dto.ProductDTO" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image) " +
            "FROM ProductDetails p " +
            "WHERE p.isExclusive = true")
    List<ProductDTO> findByIsExclusiveIsTrue();

    @Query("SELECT new com.example.groceriesapp.dto.ProductDTO" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image)" +
            " FROM ProductDetails p ORDER BY p.rating DESC LIMIT 2")
    List<ProductDTO> findByMostRated();

    @Query("SELECT new com.example.groceriesapp.dto.ProductDTO" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image)" +
            " FROM ProductDetails p WHERE p.name LIKE %:query%")
    List<ProductDTO> findByNameContaining(String query);

}
