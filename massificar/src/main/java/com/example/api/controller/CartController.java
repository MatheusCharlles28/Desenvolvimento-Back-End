package com.example.api.controller;

import com.example.api.model.CartItem;
import com.example.api.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartRepository cartRepository;
    public CartController(CartRepository cartRepository){this.cartRepository=cartRepository;}
    @PostMapping("/add")
    public ResponseEntity<CartItem> add(@RequestBody CartItem item){
        return ResponseEntity.ok(cartRepository.save(item));
    }
}
