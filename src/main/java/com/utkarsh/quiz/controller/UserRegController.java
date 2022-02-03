package com.utkarsh.quiz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utkarsh.quiz.models.Roles;
import com.utkarsh.quiz.models.User;
import com.utkarsh.quiz.services.RolesService;
import com.utkarsh.quiz.services.UserService;
import com.utkarsh.quiz.web.dto.UserRegDto;

@Controller
@RequestMapping("/registration")
public class UserRegController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RolesService rolesService;
	
	public UserRegController() {
		super();
	}

//	public UserRegController(RolesService rolesService) {
//		super();
//		this.rolesService = rolesService;
//	}
//
//	public UserRegController(UserService userService) {
//		super();
//		this.userService = userService;
//	}

	@GetMapping
	public String showRegForm(Model model) {
		model.addAttribute("user",new UserRegDto());
		model.addAttribute("rolesOb",rolesService.getAllRoles());
		return "registration";
	}
//	@ModelAttribute("user")UserRegDto userRegDto,
//	@RequestParam(name="roles")String roles
	@PostMapping
	public String saveUser(@RequestParam(name="roles")String[] roles,
			@ModelAttribute("user")UserRegDto userRegDto){
		System.out.println(roles[0]+" "+roles.length);
		User user=new User();
		user.setFirstName(userRegDto.getFirstName());
		user.setLastName(userRegDto.getLastName());
		user.setEmail(userRegDto.getEmail());
		user.setPassword(userRegDto.getPassword());
		List<Roles> rolesL=new ArrayList<Roles>();
		for(String roleId:roles) {
			Roles role=new Roles();
			role=rolesService.getRole(Long.parseLong(roleId));
			rolesL.add(role);
		}
		user.setRoles(rolesL);
		userService.saveUser(user);
		return "redirect:/login?success";
	}
}
