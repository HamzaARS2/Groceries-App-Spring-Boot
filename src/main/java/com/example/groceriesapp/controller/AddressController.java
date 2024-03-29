package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Address;
import com.example.groceriesapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping("/{customerId}")
    public Address createAddress(@RequestBody Address address, @PathVariable String customerId) {
        return service.saveAddress(address, customerId);
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address) {
        return service.updateAddress(address);
    }

    @GetMapping
    public List<Address> getAddresses() {
        return service.getAllAddresses();
    }
}
