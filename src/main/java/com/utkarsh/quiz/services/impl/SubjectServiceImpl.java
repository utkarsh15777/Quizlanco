package com.utkarsh.quiz.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkarsh.quiz.models.Subject;
import com.utkarsh.quiz.repository.SubjectRepository;
import com.utkarsh.quiz.services.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> getSubjects() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(Long id) {
		return subjectRepository.getById(id);
	}

	@Override
	public void saveQandAtoSub(Subject sub) {
		subjectRepository.save(sub);
	}

	@Override
	public void addSubject(Subject sub) {
		subjectRepository.save(sub);
	}
}
