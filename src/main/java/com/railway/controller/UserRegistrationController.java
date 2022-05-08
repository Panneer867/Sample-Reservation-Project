package com.railway.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.railway.dto.UserRegistrationDto;
import com.railway.model.User;
import com.railway.service.UserService;



@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("user", new UserRegistrationDto());

        return "user/registration";
    }

    @PostMapping
    public String register(@Valid @ModelAttribute("user") UserRegistrationDto userDto, BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());

        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "user/registration";
        }

        userService.save(userDto);
        return "redirect:registration?success";

    }

}