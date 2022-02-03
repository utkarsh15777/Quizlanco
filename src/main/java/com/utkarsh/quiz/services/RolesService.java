package com.utkarsh.quiz.services;

import java.util.List;

import com.utkarsh.quiz.models.Roles;

public interface RolesService {
	
	public Roles addRole(Roles role);
	List<Roles> getAllRoles();
	public Roles getRole(long id);
}
