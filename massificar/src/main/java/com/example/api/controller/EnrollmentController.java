package com.example.api.controller;

import com.example.api.model.Enrollment;
import com.example.api.repository.EnrollmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentRepository enrollmentRepository;
    public EnrollmentController(EnrollmentRepository enrollmentRepository){this.enrollmentRepository=enrollmentRepository;}
    @PostMapping
    public ResponseEntity<Enrollment> enroll(@RequestBody Enrollment enrollment){
        return ResponseEntity.ok(enrollmentRepository.save(enrollment));
    }
}
