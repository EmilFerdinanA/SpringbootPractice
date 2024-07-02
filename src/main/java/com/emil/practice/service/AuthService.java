package com.emil.practice.service;

import com.emil.practice.dto.request.auth.LoginRequest;
import com.emil.practice.dto.request.auth.RegisterRequest;
import com.emil.practice.dto.response.auth.LoginResponse;
import com.emil.practice.dto.response.auth.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}
