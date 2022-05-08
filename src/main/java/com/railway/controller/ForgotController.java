package com.railway.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.railway.model.User;
import com.railway.repository.UserRepository;
import com.railway.service.EmailService;

@Controller
public class ForgotController {
	Random random = new Random(1000);
	
	@Autowired
	private EmailService  emailService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bryBCryptPasswordEncoder;
	
	@RequestMapping("/forgotpassword")
	public String openEmailForm() {
		return "user/forgot_password";
	}
	
	@PostMapping("/forgotpassword")
	public String sendOTP(@RequestParam("email") String email,HttpSession session) {
		
		int otp = random.nextInt(999999);
		String subject= "OTP from Indian Railway";
		String message=""+"<div style='border:1px solid #e2e2e2; padding:20px'>"+"<h4>"+"You have accessed Indian Railway to reset your password for which One Time Password (OTP) has been generated is "+otp+"<h4>"+"</div>";
		String to=email;
		boolean flag = this.emailService.sendEmail(subject, message, to);
		
		if(flag) {
			session.setAttribute("myOtp",otp);
			session.setAttribute("email", email);
			session.setAttribute("message1"," OTP has been sent to your email, Please verify OTP");
			return "user/verify_otp";
		}else {
			return "redirect:forgotpassword?error";
	}

}
	@PostMapping("/verifyotp")
	public	String verifyotp(@RequestParam("otp") int otp, HttpSession session) {
		int myOtp = (int) session.getAttribute("myOtp");
		String email = (String) session.getAttribute("email");
		if (myOtp == otp) {
			User user = this.userRepository.findByEmail(email);
				if (user == null) {
	
					session.setAttribute("message", "User does not exist this email !");
					return "user/forgot_password";
	
				} else {
	
					return "user/forgot_change_password";
				}

		} else {
			
			session.setAttribute("message", "You have entered wrong OTP !");
			return "user/verify_otp";
		}
		
}
			
	@PostMapping("/forgotchangepassword")
	public String forgotchangepassword(@RequestParam("newpassword") String newpassword,HttpSession session) {
		String email =(String)session.getAttribute("email");
		User user = this.userRepository.findByEmail(email);
		user.setPassword(this.bryBCryptPasswordEncoder.encode(newpassword));
		this.userRepository.save(user);
		
		return "redirect:/login?success";
		
	}	

}
