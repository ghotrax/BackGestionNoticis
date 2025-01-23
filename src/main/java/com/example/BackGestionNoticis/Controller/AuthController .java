package com.example.BackGestionNoticis.Controller;

import com.example.BackGestionNoticis.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            String token = jwtService.generarToken(username);
            return Map.of("token", token);
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}