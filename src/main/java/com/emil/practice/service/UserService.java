package com.emil.practice.service;

import com.emil.practice.entity.UserAccount;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    UserAccount getByUserId(String userId);
}
