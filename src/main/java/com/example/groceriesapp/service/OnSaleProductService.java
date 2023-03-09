package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.OnSaleProductDto;
import com.example.groceriesapp.dto.ProductDto;
import com.example.groceriesapp.entity.OnSaleProduct;
import com.example.groceriesapp.mapper.ProductMapper;
import com.example.groceriesapp.repository.OneSaleProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OnSaleProductService {

    @Autowired
    private OneSaleProductRepo repository;


    public List<OnSaleProductDto> getOnSaleProducts() {
        List<OnSaleProduct> onSaleProducts = repository.findAll();
        List<OnSaleProductDto> onSaleProductDTOS = new ArrayList<>();
        for (OnSaleProduct onSaleProduct: onSaleProducts) {
            ProductDto productDTO = ProductMapper.toProductDTO(onSaleProduct.getProductDetails());
            OnSaleProductDto onSaleProductDTO = new OnSaleProductDto(
                    onSaleProduct.getId(),
                    onSaleProduct.getProductId(),
                    onSaleProduct.getSalePrice(),
                    onSaleProduct.getDiscountPercentage(),
                    onSaleProduct.getStartDate(),
                    onSaleProduct.getEndDate(),
                    productDTO
            );
            onSaleProductDTOS.add(onSaleProductDTO);
        }
        return onSaleProductDTOS;
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
