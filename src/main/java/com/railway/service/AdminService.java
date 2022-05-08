package com.railway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.railway.model.Admin;
import com.railway.repository.AdminRepository;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public AdminService(AdminRepository adminRepository) {
        super();
        this.adminRepository = adminRepository;
    }

    public Admin adminlogin(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }


}