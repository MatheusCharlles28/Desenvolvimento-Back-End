package com.example.api.repository;

import com.example.api.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GradeRepository extends JpaRepository<Grade,Long>{}
