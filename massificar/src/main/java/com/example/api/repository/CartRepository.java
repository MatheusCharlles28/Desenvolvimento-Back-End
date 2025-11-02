package com.example.api.repository;

import com.example.api.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CartRepository extends JpaRepository<CartItem,Long>{}
