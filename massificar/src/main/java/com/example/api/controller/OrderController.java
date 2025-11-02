package com.example.api.controller;

import com.example.api.model.OrderEntity;
import com.example.api.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;
    public OrderController(OrderRepository orderRepository){this.orderRepository=orderRepository;}
    @PostMapping
    public ResponseEntity<OrderEntity> create(@RequestBody OrderEntity order){
        return ResponseEntity.ok(orderRepository.save(order));
    }
}
