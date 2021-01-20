package com.nj.secretary.services.monologue.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.domain.Question;
import com.nj.secretary.services.monologue.service.MonologueService;

@Controller
@RequestMapping("/monologue/*")
public class MonologueController {
	
	@Autowired
	 //@Qualifier("monologueServiceImpl")
	MonologueService monologueService;
	
	//=====================Question===============================

	@GetMapping("addQuestionText")
	public String addQuestionText(HttpSession session) throws Exception {
		System.out.println("monologueController addQuestionText 시작");
		
		session.setAttribute("role", "gyuri");
		
		String role=(String)session.getAttribute("role");
		
		System.out.println("addQuestionText 확인합니다아아아아아 :::  "+role);
		
		
		return "question/addQuestion";
	}
	

	@PostMapping("addQuestionText")
	public String addQuestionText(String questionText, Model model) throws Exception {
		System.out.println("monologueController addQuestionText  " + questionText);
		monologueService.addQuestionText(questionText);
		
	   List<Question> questionList=monologueService.getQuestionList();
		
		model.addAttribute("questionList", questionList);
		
		System.out.println("monologueController addQuestionText  " + questionList);
		
		return "question/getQuestion";

	}
	
	
	@GetMapping("getQuestionList")
	public String getquestionList(Model model, HttpSession session) throws Exception{
		
		session.setAttribute("role", "gyuri");
		
		String role=(String)session.getAttribute("role");
		
		System.out.println("getQuestionList에서 role 확인이니이이이잉 :::"+role);
		
		List<Question> questionList=monologueService.getQuestionList();
		
		model.addAttribute("questionList", questionList);
		
		System.out.println("monologueController getQuestionList  ::  "+questionList);
		
		if(role.equals("admin")) {
			
			return "question/getQuestion";
		}else {
			return "monologue/getMonologueList";
		}
		
	}
		
	
	@PostMapping("deleteQuestionId")
	public String deleteQuestionId(@RequestParam("questionId") int questionId, Model model) throws Exception{
		
		monologueService.deleteQuestionId(questionId);
		
		System.out.println("monologueCotroller에서 deleteQuestionId 확인 :::" + questionId);
		
		List<Question> questionList = monologueService.getQuestionList();

		model.addAttribute("questionList", questionList);
		
		return "question/getQuestion";
	}
	
//	
//	@PostMapping("getQuestionId")
//	public String getQuestionId(int questionId) throws Exception{
//		System.out.println("getQuestionId 시작 합니다잉");
//		monologueService.getQuestionId(questionId);
//		System.out.println("questionId 잘가지고 오니??" + questionId);
//		
//		return "monologue/addMonologue";
//	}

	
	
	
	//=======================Monologue=========================
	
	@GetMapping("addMonologueText")
	public String addMonologueText() throws Exception{
		System.out.println("monologueController addMonologueText 시작");
		return "monologue/addMonologue";
	}
	
	@PostMapping("addMonologueText")
	public String addMonologueText(String monologueText, @RequestParam("questionId") int questionId, HttpSession session, Model model) throws Exception{
		System.out.println("monologueController postMapping 시작하니1??");
		
		monologueService.getQuestionId(questionId);
		
		
		List<Question> questionList = monologueService.getQuestionList();

		Random random=new Random();
		random.nextInt(questionList.size());
		
		model.addAttribute("randomQuestionId", random);
		
		
     	System.out.println("랜덤으로 뿌려준 questionId 확인"+random);			
		
		Monologue monologue=new Monologue();

		monologue.setMonologueText(monologueText);
		
		System.out.println("monologueController postMapping 시작하니2??");

		session.setAttribute("userId", "hyoeun");
		
		String user=(String)session.getAttribute("userId");
		
		monologue.setUserId(user);

		System.out.println("monologueController postMapping 시작하니3??");
		
		monologueService.addMonologueText(monologue);
		
		
			
		System.out.println("monologueController   addMonologueText:::::    " +monologue);
		
		System.out.println("monologueController   user:::::    " +user);

		return "monologue/addMonologue";
		
	}
	


}
