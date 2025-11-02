package com.example.api.controller;

import com.example.api.model.Product;
import com.example.api.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository){this.productRepository=productRepository;}
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.ok(productRepository.save(product));
    }
}
