package com.utkarsh.quiz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utkarsh.quiz.models.QuesAndAns;
import com.utkarsh.quiz.models.SelectedAnswer;
import com.utkarsh.quiz.models.Subject;
import com.utkarsh.quiz.models.WrapperList;
import com.utkarsh.quiz.services.SubjectService;

@Controller
@RequestMapping("/attemptQuiz")
public class QuizShowController {
	
	@Autowired
	private SubjectService subjService;
	
	@GetMapping
	public String showSubjects(Model model) {
		model.addAttribute("subjects",subjService.getSubjects());
		return "showSubjects";
	}
	
	@PostMapping
	public String getQuiz(@RequestParam("subject")String subId,Model model) {
		Subject sub=subjService.getSubjectById(Long.parseLong(subId));
		List<QuesAndAns> list=sub.getList();
		ArrayList<SelectedAnswer> upList=new ArrayList<>(list.size());
		for(QuesAndAns obj:list) {
			SelectedAnswer selA=new SelectedAnswer(
					obj.getId(),obj.getQuestion(),obj.getOption1(),obj.getOption2(),obj.getOption3(),
					obj.getOption4(),obj.getCorrectAns());
			upList.add(selA);
		}
		WrapperList wrapList=new WrapperList(upList);
//		wrapList.setSelA(upList);
		System.out.println(upList);
		if(wrapList!=null) {
			System.out.println(wrapList.getSelA());
			for(SelectedAnswer sel:wrapList.getSelA()) {
				System.out.println(sel.getId());
			}
		}
		model.addAttribute("qandalist",wrapList);
		model.addAttribute("sub",sub.getSub());
//		String[] selA=new String[list.size()];
//		model.addAttribute("selA",selA);
		return "showQuiz";
	}
	
	@PostMapping("/calculateResult")
	public String calculateResult(@ModelAttribute("qandalist")WrapperList wrapper,Model model,@RequestParam("subject")String subName) {
		int score=0;
		for(SelectedAnswer obj:wrapper.getSelA()) {
//			System.out.println(obj.getChoosenAns());
//			System.out.println(obj.getCorrectAns());
			if(obj.getCorrectAns().equals(obj.getChoosenAns())) {
				score++;
			}
		}
		System.out.println(score);
		model.addAttribute("score",score);
		model.addAttribute("sub",subName);
		return "showResult";
	}
	
}
