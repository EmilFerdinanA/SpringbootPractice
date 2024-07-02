package com.emil.practice.controller;

import com.emil.practice.constant.APIUrl;
import com.emil.practice.dto.request.auth.RegisterRequest;
import com.emil.practice.dto.response.auth.RegisterResponse;
import com.emil.practice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = APIUrl.AUTH_API)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest user) {
        RegisterResponse registerResponse = authService.register(user);
        return ResponseEntity.ok(registerResponse);
    }
}
