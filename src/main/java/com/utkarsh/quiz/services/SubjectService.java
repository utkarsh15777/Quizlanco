package com.utkarsh.quiz.services;

import java.util.List;

import com.utkarsh.quiz.models.Subject;

public interface SubjectService {

	public List<Subject> getSubjects();
	Subject getSubjectById(Long id);
	void saveQandAtoSub(Subject sub);
	public void addSubject(Subject sub);
}
