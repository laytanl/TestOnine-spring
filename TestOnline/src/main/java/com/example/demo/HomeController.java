package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/quiz")
	public String quiz() {
		return "quiz.html";
	}
	
	@GetMapping("/question")
	public String question() {
		return "question.html";
	}

}
