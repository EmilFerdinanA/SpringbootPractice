package com.emil.practice.dto.response.jwt;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTClaimsResponse {
    private String userAccountId;
    private List<String> roles;
}
