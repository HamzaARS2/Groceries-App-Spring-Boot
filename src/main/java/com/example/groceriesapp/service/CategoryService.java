package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.Category;
import com.example.groceriesapp.entity.Product;
import com.example.groceriesapp.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo repository;

    public List<Category> getCategories() {
        return repository.findAll();
    }

    public Category insertCategory(Category category) {
        return repository.save(category);
    }

    public Category insertCategoryProducts(Integer id, List<Product> products) throws NullPointerException {
        Category category = getCategoryById(id);
        if (category != null) {
            List<Product> allProducts = category.getProducts();
            allProducts.addAll(products);
            category.setProducts(allProducts);
            return category;
        }
        throw new NullPointerException("Category is null");
    }

    public List<Category> insertCategories(List<Category> categories) {
        return repository.saveAll(categories);
    }

    public Category updateCategory(Integer id, Category updatedCategory) {
        Category category = getCategoryById(id);
        if (category != null) {
            category.setName(updatedCategory.getName());
            return insertCategory(category);
        }
        return null;
    }

    public Category getCategoryById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Category getCategoryByName(String name) {
        return repository.findByName(name);
    }

    public String deleteCategory(Integer id) {
        repository.deleteById(id);
        return "Category deleted Successfully : id = " + id;
    }
}
