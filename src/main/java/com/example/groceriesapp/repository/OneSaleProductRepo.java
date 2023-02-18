package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.OnSaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface OneSaleProductRepo extends JpaRepository<OnSaleProduct,Integer> {
    List<OnSaleProduct> findByEndDateBefore(Date endDate);

//    @Query("")
//    List<OnSaleProduct> findOnSaleProducts();
}
