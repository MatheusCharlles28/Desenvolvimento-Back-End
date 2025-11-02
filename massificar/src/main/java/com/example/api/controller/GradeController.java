package com.example.api.controller;

import com.example.api.model.Grade;
import com.example.api.repository.GradeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradeController {
    private final GradeRepository gradeRepository;
    public GradeController(GradeRepository gradeRepository){this.gradeRepository=gradeRepository;}
    @PostMapping
    public ResponseEntity<Grade> save(@RequestBody Grade grade){
        return ResponseEntity.ok(gradeRepository.save(grade));
    }
}
