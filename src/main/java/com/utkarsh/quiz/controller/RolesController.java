package com.utkarsh.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utkarsh.quiz.models.Roles;
import com.utkarsh.quiz.services.RolesService;

@Controller
@RequestMapping("/addRole")
public class RolesController {
	
	@Autowired
	private RolesService rolesService;
	
	@GetMapping
	public String addRoles(Model model){
		model.addAttribute("roleOb",new Roles()); 
		return "roles";
	}
	
	@PostMapping
	public String saveRoles(@ModelAttribute("roleOb")Roles role) {
		rolesService.addRole(role);
		return "index";
	}
}
