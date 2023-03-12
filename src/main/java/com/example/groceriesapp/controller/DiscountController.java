package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Discount;
import com.example.groceriesapp.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    @Autowired
    private DiscountService service;




    @PostMapping("/publish")
    public Discount saveOnSaleProduct(@RequestBody Discount onSaleProduct) {
        return service.insertOnSaleProduct(onSaleProduct);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOnSaleProduct(@PathVariable Integer id) {
        return service.deleteOnSaleProduct(id);
    }

    @DeleteMapping("/delete/expired")
    public List<Discount> deleteExpiredOnSaleProducts() {
        return service.deleteExpiredOnSaleProducts();
    }
}
