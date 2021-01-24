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

	@GetMapping("addQuestion")
	public String addQuestion(HttpSession session) throws Exception {
		System.out.println("monologueController addQuestion 1시작");
		
		//session.setAttribute("role", "gyuri");
		
		//String role=(String)session.getAttribute("role");
		
		//System.out.println("addQuestionText 확인합니다아아아아아 :::  "+role);
		
		return "question/addQuestion";
	}
	

	@PostMapping("addQuestion")
	public String addQuestion(String questionText, Model model) throws Exception {
		System.out.println("monologueController addQuestion  " + questionText);
		monologueService.addQuestion(questionText);
		
	    List<Question> questionList=monologueService.getQuestionList();
		
		model.addAttribute("questionList", questionList);
		
		System.out.println("monologueController addQuestionText  " + questionList);
		
		return "question/getQuestionList";

	}
	
	
	@GetMapping("getQuestionList")
	public String getQuestionList(Model model, HttpSession session) throws Exception{
		
		session.setAttribute("role", "gyuri");
		
		String role=(String)session.getAttribute("role");
		
		System.out.println("getQuestionList에서 role 확인이니이이이잉 :::"+role);
		
		List<Question> questionList=monologueService.getQuestionList();
		
		model.addAttribute("questionList", questionList);
		
		System.out.println("monologueController getQuestionList  ::  "+questionList);

		return "question/getQuestionList";
		
	}
		
	
	@PostMapping("deleteQuestion")
	public String deleteQuestion(@RequestParam("questionId") int questionId, Model model) throws Exception{
		
		monologueService.deleteQuestion(questionId);
		
		System.out.println("monologueCotroller에서 deleteQuestionId 확인 :::" + questionId);
		
		List<Question> questionList = monologueService.getQuestionList();

		model.addAttribute("questionList", questionList);
		
		return "question/getQuestionList";
	}
	


	
	
	
	//=======================Monologue=========================
	
	@GetMapping("addMonologue")
	public String addMonologue() throws Exception{
		System.out.println("monologueController addMonologueText 시작");
		return "monologue/addMonologue";
	}
	
	@PostMapping("addMonologue")
	public String addMonologue(@ModelAttribute Monologue monologue, HttpSession session, Model model) throws Exception{
		System.out.println("monologueController addMonologue  postMapping 시작하니1??");
//		List<Question> questionList = monologueService.getQuestionList();
//		Random random=new Random();
//		random.nextInt(questionList.size());
//		model.addAttribute("randomQuestionId", random);
    // 	System.out.println("랜덤으로 뿌려준 questionId 확인"+random);			
		
		
		monologue.getShareStatus();
		
		if(monologue.getShareStatus().trim().equals("0,1")) {
			monologue.setShareStatus("1");
		}
		
		System.out.println("확인::"+monologue.getShareStatus());
    
		monologue.setMonologueText(monologue.getMonologueText());
		
		session.setAttribute("userId", "hyoeun");
		
		String user=(String)session.getAttribute("userId");
		
		monologue.setUserId(user);

		monologueService.addMonologue(monologue);
		
		System.out.println("monologueController   addMonologue:::::    " +monologue);
		
		System.out.println("monologueController   user:::::    " +user);

		return "monologue/addMonologue";
		
	}

	
	@GetMapping("getMonologueList")
	public String getMonologueList(Model model, HttpSession session) throws Exception{
		System.out.println("getMonologueList 시작해유");
		
		session.setAttribute("userId", "gyuri");
		
		String userId=(String)session.getAttribute("userId");
		
		System.out.println("getMonologueList에서 userId 확인이니이이이잉 :::"+userId);
		
		List<Monologue> monologueList=monologueService.getMonologueList((session.getAttribute("userId")).toString());
		
		model.addAttribute("monologueList", monologueList);
		
		System.out.println("monologueController getMonologueList  ::  "+monologueList);
		
		return "monologue/getMonologueList";
		
	}
	
	
	
	
	@GetMapping("getMonologue")
	public String getMonologueText(int monologueId, Model model) throws Exception{
		
		System.out.println("getMonologueText 시작합니다잉");
		
		Monologue monologue=monologueService.getMonologue(monologueId);
		
		model.addAttribute("monologue", monologue);
		
		System.out.println("getMonologue에서 monologueId 확인 :::  "+monologueId);
		
		System.out.println("getMonologue  확인 :::  "+monologue);
		
		return "monologue/getMonologue";
		
	}
	
	
	@GetMapping("deleteMonologue")
	public String deleteMonologue( Model model, HttpSession session) throws Exception{
		System.out.println("deleteMonologue GepMapping 시작 합니다잉~~");
		
		session.setAttribute("userId", "hyoeun");
		
		String userId=(String)session.getAttribute("userId");
		
		System.out.println("deleteMonologue에서 userId 확인이니이이이잉 :::"+userId);
		
	    List<Monologue> monologueList=monologueService.getMonologueList((session.getAttribute("userId")).toString());
		
		model.addAttribute("monologueList", monologueList);
		
		System.out.println("monologueController deleteMonologue  ::  "+monologueList);
		
		return "monologue/deleteMonologue";
	}
	
	
	@PostMapping("deleteMonologue")
	public String deleteMonologue(@RequestParam("monologueId") int monologueId, Model model, HttpSession session) throws Exception{
		System.out.println("deleteMonologue PostMapping 시작 합니다잉~~");
		
		monologueService.deleteMonologue(monologueId);
		
		System.out.println("deleteMonologue monologueId 확인 ::::  "+monologueId);
		
	    List<Monologue> monologueList=monologueService.getMonologueList((session.getAttribute("userId")).toString());
		
		model.addAttribute("monologueList", monologueList);
		
		System.out.println("monologueController deleteMonologue  ::  "+monologueList);
		
		return "monologue/getMonologueList";
	}

	
	@GetMapping("updateMonologue")
	public String updateMonologue(@RequestParam("monologueId") int monologueId, Model model) throws Exception{
		System.out.println("updateMonologue 시작 합니다!");
		
        Monologue monologue=monologueService.getMonologue(monologueId);
        
		model.addAttribute("monologue", monologue);
		
		System.out.println("updateMonologue에서 monologueId 확인 :::  "+monologueId);
		
		System.out.println("updateMonologue 확인 :::  "+monologue);
		
		return "monologue/updateMonologue";
	}
	
	@PostMapping("updateMonologue")
	public String updateMonologue(Monologue monologue, Model model) throws Exception{
		
		monologue.getShareStatus();
		
		if(monologue.getShareStatus().trim().equals("0,1")) {
			monologue.setShareStatus("1");
		}
		
		monologueService.updateMonologue(monologue);
		
		System.out.println("updateMonologue 확인합니다" +monologue);
		
		return "monologue/getMonologue";
		
	}
	
	
	
}


