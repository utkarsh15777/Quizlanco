package com.utkarsh.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utkarsh.quiz.models.QuesAndAns;
import com.utkarsh.quiz.models.Subject;
import com.utkarsh.quiz.services.SubjectService;

@Controller
@RequestMapping("/addQuiz")
public class QuesAndAnsController {
	
	@Autowired
	private SubjectService subService;
	
	@GetMapping
	public String addQuiz(Model model) {
		model.addAttribute("subjects",subService.getSubjects());
		model.addAttribute("qandans",new QuesAndAns());
		return "quizForm";
	}
	
	@PostMapping
	public String saveQuiz(@ModelAttribute("qandans")QuesAndAns qanda,@RequestParam("subject")String subId) {
		Subject sub=subService.getSubjectById(Long.parseLong(subId));
		sub.getList().add(qanda);
		subService.saveQandAtoSub(sub);
		return "index";
	}
}
