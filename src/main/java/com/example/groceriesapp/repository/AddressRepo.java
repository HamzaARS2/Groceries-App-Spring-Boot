package com.example.groceriesapp.repository;

import com.example.groceriesapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
