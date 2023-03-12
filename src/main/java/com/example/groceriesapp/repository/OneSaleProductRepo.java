package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OneSaleProductRepo extends JpaRepository<Discount,Integer> {
    List<Discount> findByEndDateBefore(Date endDate);

//    @Query("")
//    List<OnSaleProduct> findOnSaleProducts();
}
