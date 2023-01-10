package com.example.groceriesapp;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class GroceriesAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(GroceriesAppApplication.class, args);
	}



}
