package com.example.groceriesapp.service;

import com.example.groceriesapp.dto.ProductDTO;
import com.example.groceriesapp.entity.ProductDetails;
import com.example.groceriesapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repository;


    public List<ProductDetails> getProductDetails() {
        return repository.findAll();
    }

    public ProductDetails insertProduct(ProductDetails Product) {
        return repository.save(Product);
    }

    public List<ProductDetails> insertProducts(List<ProductDetails> products) {
        return repository.saveAll(products);
    }

    public ProductDetails updateProduct(Integer id, ProductDetails updatedProduct) {
        ProductDetails product = repository.findById(id).orElse(null);
        if (product != null) {
            product.setCategoryId(updatedProduct.getCategoryId());
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setPriceUnit(updatedProduct.getPriceUnit());
            product.setNutrition(updatedProduct.getNutrition());
            product.setImage(updatedProduct.getImage());
            return repository.save(product);
        }
        return null;
    }

    public ProductDetails getProductDetailsById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<ProductDTO> getExclusiveProducts() {
        return repository.findByIsExclusiveIsTrue();
    }




    public String deleteProduct(Integer id) {
        repository.deleteById(id);
        return "Product deleted Successfully : id = " + id;
    }


}
