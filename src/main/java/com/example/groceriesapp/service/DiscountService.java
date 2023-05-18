package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.Discount;
import com.example.groceriesapp.repository.OneSaleProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private OneSaleProductRepo repository;


    public Discount insertOnSaleProduct(Discount discount) {
        return repository.save(discount);
    }

    public List<Discount> getDiscounts() {
        return repository.findAll();
    }

    public String deleteOnSaleProduct(Integer id) {
        repository.deleteById(id);
        return "OnSaleProduct deleted Successfully : id = " + id;
    }

    public List<Discount> deleteExpiredOnSaleProducts() {
        List<Discount> expiredOnSaleProducts = repository.findByEndDateBefore(new Date());
        expiredOnSaleProducts.forEach( expiredOnSaleProduct -> {
            repository.delete(expiredOnSaleProduct);
        });
        return expiredOnSaleProducts;
    }


}
