package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.FavoriteProductDto;
import com.example.groceriesapp.entity.FavoriteProduct;
import com.example.groceriesapp.mapper.ProductMapper;
import com.example.groceriesapp.repository.FavoriteProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteProductService {

    @Autowired
    private FavoriteProductRepo repository;


    public List<FavoriteProduct> getFavoriteProductsByCustomerId(String id) {
        return repository.findByCustomerId(id);
    }

    public FavoriteProduct addProductToCustomerFavorites(int productId, String customerId) {
        FavoriteProduct existingFavoriteProduct = repository.findByCustomerIdAndProductId(customerId, productId);
        if (existingFavoriteProduct != null)
            return existingFavoriteProduct;
        return repository.save(new FavoriteProduct(productId, customerId));
    }

    public void removeProductFromCustomerFavorites(Integer id) {
        repository.deleteById(id);
    }


    @Transactional
    public void removeFavoriteProduct(Integer productId, String customerId) {
        repository.deleteByCustomerIdAndProductId(customerId, productId);
    }
}
