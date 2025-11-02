package com.example.api.repository;

import com.example.api.model.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LikeRepository extends JpaRepository<LikeEntity,Long>{}
