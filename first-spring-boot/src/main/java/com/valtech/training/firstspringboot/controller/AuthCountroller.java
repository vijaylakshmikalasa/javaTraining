package com.valtech.training.firstspringboot.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.firstspringboot.models.ChangePassWordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.services.AuthService;

@Controller
public class AuthCountroller {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping("/changePassword")
	public String changePassword() {
		return "changePassword";
	}
	
	
	@PostMapping("/changePassword")
	public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails,@ModelAttribute ChangePassWordModel pwdModel,Model model) {
		if(Objects.equals(pwdModel.getNewPassword(), pwdModel.getConfirmPassword())) {
			if(authService.ChangePassword(pwdModel)) {
				model.addAttribute("message","password changed succesful");
				
			}else {
				model.addAttribute("message","oldpassword not  match");
				return "changePassword";
			}
		}else {
			model.addAttribute("message"," password and current password not  match");
			return "changePassword";
			
		}
		
		return "redirect:logout";
	}
	
	
	
	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute RegisterUserModel regUserModel, Model model) {
		if(Objects.equals(regUserModel.getPassword(),regUserModel.getConfirmPassword())) {
			authService.createUser(regUserModel);
			model.addAttribute("message","User registration successful..pls login to proceed..");
			
		}
		else {
			model.addAttribute("message","Password and confirm password doesn't match");
			return "register";
		}
		return "login";
	}
	

	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/anon")
	@ResponseBody
	public String anonPage() {
		return "Anonymous Page";

	}

	@GetMapping("/user")
	@ResponseBody
	public String userPage() {
		return "User Page";

	}

	@GetMapping("/admin")
	@ResponseBody
	public String adminPage() {
		return "Admin Page";

	}

}
