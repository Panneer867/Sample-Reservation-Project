package com.railway.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.railway.model.User;
import com.railway.repository.UserRepository;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "user/user_login";
    }

    @GetMapping("/userpage")
    public String userpage(Model model, Principal principal) {
        String name = principal.getName();
        User findByEmail = userRepository.findByEmail(name);
        model.addAttribute("firstName", findByEmail.getFirstName());
        model.addAttribute("lastName", findByEmail.getLastName());
        return "user/user_page";
    }

    @GetMapping("/accessdenied")
    public String getAccessDenied() {
        return "accessDenied";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    
   
}