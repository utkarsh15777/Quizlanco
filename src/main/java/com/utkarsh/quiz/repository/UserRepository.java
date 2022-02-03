package com.utkarsh.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarsh.quiz.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByEmail(String email);
}
