package com.utkarsh.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class HomeController {
	
//	@PreAuthorize(value = "isAutheticated()")
	@GetMapping
	public String home() {
		
		return "index";
	}
	
}
