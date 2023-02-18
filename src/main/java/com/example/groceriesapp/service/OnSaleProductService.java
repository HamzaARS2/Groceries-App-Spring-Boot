package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.OnSaleProductDTO;
import com.example.groceriesapp.dto.ProductDTO;
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


    public List<OnSaleProductDTO> getOnSaleProducts() {
        List<OnSaleProduct> onSaleProducts = repository.findAll();
        List<OnSaleProductDTO> onSaleProductDTOS = new ArrayList<>();
        for (OnSaleProduct onSaleProduct: onSaleProducts) {
            ProductDTO productDTO = ProductMapper.toProductDTO(onSaleProduct.getProductDetails());
            OnSaleProductDTO onSaleProductDTO = new OnSaleProductDTO(
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
