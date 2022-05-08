package com.railway.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.railway.dto.UserRegistrationDto;
import com.railway.model.User;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

    User findByEmail(String email);
    
    List<User> getAllUsers();
    
    void deleteUserById(long id);

}