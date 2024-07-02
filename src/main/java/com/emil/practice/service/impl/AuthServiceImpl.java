package com.emil.practice.service.impl;

import com.emil.practice.constant.UserRole;
import com.emil.practice.dto.request.auth.RegisterRequest;
import com.emil.practice.dto.response.auth.RegisterResponse;
import com.emil.practice.entity.Role;
import com.emil.practice.entity.UserAccount;
import com.emil.practice.repository.UserAccountRepository;
import com.emil.practice.service.AuthService;
import com.emil.practice.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserAccountRepository userAccountRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        Role role = roleService.getOrSaveRole(UserRole.ROLE_USER);
        String hashPassword = passwordEncoder.encode(registerRequest.getPassword());

        UserAccount userAccount = UserAccount.builder()
                .username(registerRequest.getUsername())
                .password(hashPassword)
                .roles(List.of(role))
                .isEnable(true)
                .build();
        userAccountRepository.saveAndFlush(userAccount);

        List<String> roles = userAccount.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return RegisterResponse.builder()
                .username(userAccount.getUsername())
                .roles(roles)
                .build();
    }
}
