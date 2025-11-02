package com.example.api.repository;

import com.example.api.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{}
