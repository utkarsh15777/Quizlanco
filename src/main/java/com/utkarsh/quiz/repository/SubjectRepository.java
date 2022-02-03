package com.utkarsh.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarsh.quiz.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

}
