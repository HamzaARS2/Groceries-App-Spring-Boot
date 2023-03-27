package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Address;
import com.example.groceriesapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping
    public Integer saveAddress(@RequestBody Address address) {
        return service.saveAddress(address);
    }
}
