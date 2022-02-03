package com.utkarsh.quiz.services.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.utkarsh.quiz.models.Roles;
import com.utkarsh.quiz.models.User;
import com.utkarsh.quiz.repository.UserRepository;
import com.utkarsh.quiz.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid Username and Password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),mapRolestoAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolestoAuthorities(Collection<Roles> roles){
		return roles.stream().map(role->new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
}
