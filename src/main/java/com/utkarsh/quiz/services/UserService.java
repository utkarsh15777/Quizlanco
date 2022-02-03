package com.utkarsh.quiz.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.utkarsh.quiz.models.User;
import com.utkarsh.quiz.web.dto.UserRegDto;

public interface UserService extends UserDetailsService{
	 User saveUser(User user);
}
