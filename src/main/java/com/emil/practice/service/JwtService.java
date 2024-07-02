package com.emil.practice.service;


import com.emil.practice.dto.response.jwt.JWTClaimsResponse;
import com.emil.practice.entity.UserAccount;

public interface JwtService {
    String generateToken(UserAccount userAccount);
    Boolean verifyToken(String bearerToken);
    JWTClaimsResponse getClaimsByToken(String bearerToken);
}
