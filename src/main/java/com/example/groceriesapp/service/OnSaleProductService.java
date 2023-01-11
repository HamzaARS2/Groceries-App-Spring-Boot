package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.OnSaleProduct;
import com.example.groceriesapp.repository.OneSaleProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class OnSaleProductService {

    @Autowired
    private OneSaleProductRepo repository;


    public List<OnSaleProduct> getOnSaleProducts() {
        return repository.findAll();
    }

    public OnSaleProduct insertOnSaleProduct(OnSaleProduct onSaleProduct) {
        return repository.save(onSaleProduct);
    }

    public String deleteOnSaleProduct(Integer id) {
        repository.deleteById(id);
        return "OnSaleProduct deleted Successfully : id = " + id;
    }

    public List<OnSaleProduct> deleteExpiredOnSaleProducts() {
        List<OnSaleProduct> expiredOnSaleProducts = repository.findByEndDateBefore(new Date());
        expiredOnSaleProducts.forEach( expiredOnSaleProduct -> {
            repository.delete(expiredOnSaleProduct);
        });
        return expiredOnSaleProducts;
    }


}
