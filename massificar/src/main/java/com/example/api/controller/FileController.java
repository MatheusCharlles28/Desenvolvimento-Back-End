package com.example.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${file.upload-dir}")
    private String uploadDir;
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException{
        if(file.isEmpty()) return ResponseEntity.badRequest().body(java.util.Map.of("status","empty"));
        if(!file.getOriginalFilename().toLowerCase().endsWith(".pdf")) return ResponseEntity.badRequest().body(java.util.Map.of("status","only-pdf"));
        Path dir=Paths.get(uploadDir);
        if(!Files.exists(dir)) Files.createDirectories(dir);
        Path dest=dir.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(),dest);
        return ResponseEntity.ok(java.util.Map.of("status","saved","path",dest.toString()));
    }
}
