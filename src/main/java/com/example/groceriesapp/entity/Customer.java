package com.example.groceriesapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customers")
public class Customer {
    @Id @GeneratedValue
    private Integer id;
    @NonNull
    @Column(name = "doc_id")
    private String docId;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phone;
    @NonNull
    private String address;
}
