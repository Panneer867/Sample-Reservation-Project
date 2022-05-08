package com.railway.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.railway.model.User;
import com.railway.repository.UserRepository;

@Controller
@RequestMapping("/changepassword")
public class PasswordChangeController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;



    @GetMapping
    public String passwordChange(Model model, Principal principal) {
    	String name = principal.getName();
        User findByEmail = userRepository.findByEmail(name);
        model.addAttribute("firstName", findByEmail.getFirstName());

        return "user/change_password";
    }

    @PostMapping
    public String passwordChangeProcess(@RequestParam("oldPassword") String oldPassword, 
    									@RequestParam("newPassword") String newPassword, Principal principal) {

        String userName = principal.getName();
        User findByEmail = this.userRepository.findByEmail(userName);

        if (this.bCryptPasswordEncoder.matches(oldPassword, findByEmail.getPassword())) {

            findByEmail.setPassword(this.bCryptPasswordEncoder.encode(newPassword));
            this.userRepository.save(findByEmail);
            return "redirect:changepassword?success";
        } else {
            return "redirect:changepassword?error";
        }


    }

}