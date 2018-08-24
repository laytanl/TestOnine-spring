package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Answer;
import com.example.demo.Answer1;
import com.example.demo.Question;
import com.example.demo.mapper.QuestionMapper;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
	/**
	 * 自动装配（）
	 */
	@Autowired
	QuestionMapper mapper;
	double a;
//	public String foo(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			HttpSession session,
//			ServletContext application
//			) {
//		String subject=request.getParameter("subject");
//		
//		return "";
//	}
	
//	@PostMapping("/answers")
//	public Map<String,Object> submitAnswer(
//			@RequestBody List<Answer> answers
//			){
//		for (Answer answer : answers) {
//			System.out.println(answer);
//		}
//		
//		Map<String,Object>data =new HashMap<>();
//		return data;
//	}
	
	@PostMapping
	public Map<String, Object> create (@RequestBody Question question){
		System.out.println("QuestionController: "+question);
		//在控制器中调用Mapper中的方法
		mapper.add(question);
		Map<String, Object> msg=new HashMap<>();
		msg.put("msg", "ok");
		return msg;
	}
	
	@PostMapping("/submit")
	public double send(@RequestBody List<Answer>answers){
		for (Answer answer : answers) {
			System.out.println(answer);
		}		
		Map<String, Object> msg=new HashMap<>();
		msg.put("msg", "ok");
		return a;
	}
	@GetMapping("/answer")
	public Double answer() {
		return a;
	}
	
	@GetMapping("/answer2")
	public List<Question> answer2() {
		return mapper.ans();
	}
	
	@GetMapping
	public List<Question> page(
			@RequestParam(name="l",defaultValue="10",required=false) int size,
			@RequestParam(name="s",defaultValue="0",required=false) int start){
		return mapper.list(size,start);
	}

}
