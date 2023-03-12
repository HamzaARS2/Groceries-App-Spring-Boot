package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.FavoriteProductDto;
import com.example.groceriesapp.dto.Product;
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


    public List<FavoriteProductDto> getFavoriteProductsByCustomerId(String id) {
        List<FavoriteProduct> favoriteProducts =  repository.findByCustomerId(id);
        List<FavoriteProductDto> favoriteProductDtos = new ArrayList<>();
        for (FavoriteProduct favoriteProduct : favoriteProducts) {
            Product product = ProductMapper.toProduct(favoriteProduct.getProductDetails());
            FavoriteProductDto favoriteProductDto = new FavoriteProductDto(
                    favoriteProduct.getId(),
                    favoriteProduct.getCustomerId(),
                    favoriteProduct.getProductId(),
                    favoriteProduct.getCreatedAt().toString(),
                    product
            );
            favoriteProductDtos.add(favoriteProductDto);
        }
        return favoriteProductDtos;
    }

    public void addProductToCustomerFavorites(FavoriteProduct favoriteProduct) {
        repository.save(favoriteProduct);
    }

    public void removeProductFromCustomerFavorites(Integer id) {
        repository.deleteById(id);
    }


    @Transactional
    public void removeFavoriteProduct(Integer productId, String customerId) {
        repository.deleteByCustomerIdAndProductId(customerId, productId);
    }
}
