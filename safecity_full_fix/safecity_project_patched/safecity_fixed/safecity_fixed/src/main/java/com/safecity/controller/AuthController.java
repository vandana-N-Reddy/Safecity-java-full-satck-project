package com.safecity.controller;

import com.safecity.model.User;
import com.safecity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        String result = userService.register(user);
        return switch (result) {
            case "EMAIL_EXISTS" -> ResponseEntity.badRequest().body(Map.of("message", "EMAIL_EXISTS"));
            case "SUCCESS" -> ResponseEntity.ok(Map.of("message", "SUCCESS"));
            default -> ResponseEntity.internalServerError().body(Map.of("message", "UNKNOWN"));
        };
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.getOrDefault("email", "");
        String password = body.getOrDefault("password", "");
        User user = userService.login(email, password);
        if (user == null) {
            return ResponseEntity.status(401).body(Map.of("message", "INVALID_CREDENTIALS"));
        }
        return ResponseEntity.ok(Map.of(
                "message", "SUCCESS",
                "userId", user.getId(),
                "name", user.getName(),
                "role", user.getRole(),
                "email", user.getEmail()
        ));
    }
}
