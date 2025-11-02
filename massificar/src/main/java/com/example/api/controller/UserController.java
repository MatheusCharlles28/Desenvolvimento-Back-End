package com.example.api.controller;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository){this.userRepository=userRepository;}
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user){
        User saved=userRepository.save(user);
        return ResponseEntity.ok(saved);
    }
    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody Map<String,String> body){
        String email=body.get("email");
        String password=body.get("password");
        return userRepository.findByEmail(email)
                .filter(u->u.getPassword().equals(password))
                .map(u->ResponseEntity.ok(Map.of("status","ok","userId",u.getId())))
                .orElse(ResponseEntity.status(401).body(Map.of("status","unauthorized")));
    }
}
