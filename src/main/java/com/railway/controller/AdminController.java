package com.railway.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.railway.model.Admin;
import com.railway.service.AdminService;
import com.railway.service.UserService;


@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
   	private UserService userService;

    @GetMapping("/adminLogin")
    public String adminlogin(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/admin_login";
    }


    @PostMapping("/adminDashboard")
    public String dashboard(@ModelAttribute("admin") Admin admin) {
        Admin authenticate = adminService.adminlogin(admin.getEmail(), admin.getPassword());

        if (Objects.nonNull(authenticate)) {
            return "admin/dashboard";
        } else {
            return "redirect:/adminLogin?error";
        }
    }


    @GetMapping("/adminlogout")
    public String logout(Model model) {
        return "redirect:adminLogin?logout";
    }
    
    @GetMapping("/usermanagement")
	public String usersList(Model model) {
		model.addAttribute("listUsers",userService.getAllUsers());
		return "admin/user_management";
	}
    
    @RequestMapping(value="/deleteuser-{id}",method= {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteUsers(@PathVariable (value = "id") long id) {
    	this.userService.deleteUserById(id);
    	return "redirect:/usermanagement";
    	
    }

}