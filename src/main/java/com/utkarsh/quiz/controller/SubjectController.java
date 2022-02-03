package com.utkarsh.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utkarsh.quiz.models.QuesAndAns;
import com.utkarsh.quiz.models.Subject;
import com.utkarsh.quiz.services.SubjectService;

@Controller
@RequestMapping("/addSubject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping
	public String addSubject(Model model) {
		model.addAttribute("subject",new Subject());
		return "addSubject";
	}
	
	@PostMapping
	public String saveSubject(@ModelAttribute("subject")Subject sub) {
		System.out.println("Subject: "+sub.getSub());
//		QuesAndAns oj1=new QuesAndAns();
//		oj1.setQuestion("What is the 2*2");
//		oj1.setOption1("1");
//		oj1.setOption1("2");
//		oj1.setOption1("3");
//		oj1.setOption1("4");
//		oj1.setCorrectAns("4");
//		sub.getList().add(oj1);
		subjectService.addSubject(sub);
		return "index";
	}
}
