package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {


    @Query("SELECT p FROM Product p ")
    List<Product> findAllProducts();

    List<Product> findProductsByCategoryId(int id);


    @Query("SELECT p " +
            "FROM Product p " +
            "WHERE p.isExclusive = true  " +
            "UNION " +
            "SELECT p " +
            "FROM Product p ORDER BY p.rating DESC LIMIT 7")
    List<Product> findMostRatedAndExclusive();

//    @Query("SELECT * " +
//            "FROM ProductDetails p " +
//            "WHERE p.isExclusive = true ")
//    List<ProductDetails> getAll();


    @Query("SELECT p FROM Product p JOIN p.discount d WHERE d.endDate > CURRENT_DATE")
    List<Product> findAllWithDiscount();

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:query%")
    Page<Product> findByNameContaining(String query, Pageable pageable);

}
