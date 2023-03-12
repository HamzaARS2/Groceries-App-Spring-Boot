package com.example.groceriesapp.repository;

import com.example.groceriesapp.dto.Product;
import com.example.groceriesapp.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductDetails,Integer> {


    @Query("SELECT new com.example.groceriesapp.dto.Product" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image) " +
            "FROM ProductDetails p ")
    List<Product> findAllProducts();
    @Query("SELECT new com.example.groceriesapp.dto.Product" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image, p.isExclusive) " +
            "FROM ProductDetails p " +
            "WHERE p.isExclusive = true")
    List<Product> findByIsExclusiveIsTrue();

    @Query("SELECT new com.example.groceriesapp.dto.Product" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image, p.isExclusive)" +
            " FROM ProductDetails p ORDER BY p.rating DESC LIMIT 7")
    List<Product> findByMostRated();

    @Query("SELECT p " +
            "FROM ProductDetails p " +
            "WHERE p.isExclusive = true " +
            "UNION " +
            "SELECT p " +
            "FROM ProductDetails p ORDER BY p.rating DESC LIMIT 7")
    List<ProductDetails> findMostRatedAndExclusive();

//    @Query("SELECT * " +
//            "FROM ProductDetails p " +
//            "WHERE p.isExclusive = true ")
//    List<ProductDetails> getAll();


    @Query("SELECT p FROM ProductDetails p JOIN p.discount d WHERE d.endDate > CURRENT_DATE")
    List<ProductDetails> findAllWithDiscount();

    @Query("SELECT new com.example.groceriesapp.dto.Product" +
            "(p.id, p.categoryId, p.name, p.price, p.priceUnit, p.image)" +
            " FROM ProductDetails p WHERE p.name LIKE %:query%")
    List<Product> findByNameContaining(String query);

}
