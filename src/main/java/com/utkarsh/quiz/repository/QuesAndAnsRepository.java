package com.utkarsh.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarsh.quiz.models.QuesAndAns;

public interface QuesAndAnsRepository extends JpaRepository<QuesAndAns,Long>{

}
