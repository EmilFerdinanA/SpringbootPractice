package com.emil.practice.service;

import com.emil.practice.constant.UserRole;
import com.emil.practice.entity.Role;

public interface RoleService {
    Role getOrSaveRole(UserRole role);
}
