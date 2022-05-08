package com.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.model.User;

public interface UserRepository extends JpaRepository < User, Long > {

    User findByEmail(String email);

}