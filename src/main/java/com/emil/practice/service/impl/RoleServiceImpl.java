package com.emil.practice.service.impl;

import com.emil.practice.constant.UserRole;
import com.emil.practice.entity.Role;
import com.emil.practice.repository.RoleRepository;
import com.emil.practice.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Role getOrSaveRole(UserRole role) {
        return roleRepository.findByRole(role).orElseGet(() ->
                roleRepository.saveAndFlush(Role.builder().role(role).build())
        );
    }
}
