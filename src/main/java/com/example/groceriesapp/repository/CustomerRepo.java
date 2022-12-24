package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
