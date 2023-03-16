package com.example.groceriesapp.controller;

import com.example.groceriesapp.dto.FavoriteProductDto;
import com.example.groceriesapp.entity.FavoriteProduct;
import com.example.groceriesapp.service.FavoriteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/favorites")
public class FavoriteProductController {


    @Autowired
    private FavoriteProductService service;


    @GetMapping("/{id}")
    public List<FavoriteProduct> getCustomerFavoriteProducts(@PathVariable("id") String id) {
        return service.getFavoriteProductsByCustomerId(id);
    }

    @PostMapping("/create/{productId}/{customerId}")
    public FavoriteProduct saveFavoriteProduct(@PathVariable("productId") int productId, @PathVariable("customerId") String customerId) {
        return service.addProductToCustomerFavorites(productId, customerId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFavoriteProduct(@PathVariable("id") Integer id) {
        service.removeProductFromCustomerFavorites(id);
    }

    @DeleteMapping("/delete/{productId}/{customerId}")
    public void deleteFavoriteProduct(
            @PathVariable("productId") Integer productId,
            @PathVariable("customerId") String customerId
    ) {
        service.removeFavoriteProduct(productId, customerId);

    }
}
