package com.example.easynotes.controller;


import com.example.easynotes.model.PriceEnitity;
import com.example.easynotes.repository.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ProductController {
    @Autowired
    Product product;
    @GetMapping("/all")
    public List<PriceEnitity> getProducts() {
        return product.findAll();
    } // Get all Prices for a product on Amazon


}
