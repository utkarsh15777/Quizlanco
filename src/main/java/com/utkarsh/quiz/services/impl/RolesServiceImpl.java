package com.utkarsh.quiz.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkarsh.quiz.models.Roles;
import com.utkarsh.quiz.repository.RolesRepository;
import com.utkarsh.quiz.services.RolesService;

@Service
public class RolesServiceImpl implements RolesService {
	
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public Roles addRole(Roles role) {
		return rolesRepository.save(role);
	}

	@Override
	public List<Roles> getAllRoles() {
		// TODO Auto-generated method stub
		return rolesRepository.findAll();
	}

	@Override
	public Roles getRole(long id) {
		return rolesRepository.getById(id);
	}

}
