package com.example.api.repository;

import com.example.api.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{}
