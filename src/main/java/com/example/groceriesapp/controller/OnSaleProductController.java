package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.OnSaleProduct;
import com.example.groceriesapp.service.OnSaleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onsaleproducts")
public class OnSaleProductController {

    @Autowired
    private OnSaleProductService service;

    @GetMapping()
    public List<OnSaleProduct> findAllOnSaleProducts() {
        return service.getOnSaleProducts();
    }

    @PostMapping("/publish")
    public OnSaleProduct saveOnSaleProduct(@RequestBody OnSaleProduct onSaleProduct) {
        return service.insertOnSaleProduct(onSaleProduct);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOnSaleProduct(@PathVariable Integer id) {
        return service.deleteOnSaleProduct(id);
    }

    @DeleteMapping("/delete/expired")
    public List<OnSaleProduct> deleteExpiredOnSaleProducts() {
        return service.deleteExpiredOnSaleProducts();
    }
}
