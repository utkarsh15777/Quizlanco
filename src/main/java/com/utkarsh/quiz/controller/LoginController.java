package com.utkarsh.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utkarsh.quiz.models.User;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public String showLoginForm(Model model) {
		return "login";
	}
}
