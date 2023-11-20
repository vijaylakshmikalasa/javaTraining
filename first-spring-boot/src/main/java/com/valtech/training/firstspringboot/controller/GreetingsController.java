package com.valtech.training.firstspringboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingsController {

//	@RequestMapping(method = RequestMethod.GET,path="/hello")
//	@ResponseBody
	@GetMapping("/hello")
	public String hello(@RequestParam("name")String name, Model model) {
//		return "hello gagan";
//		HttpServletRequest request, HttpServletResponse responce,
//		String name= request.getParameter("name");
		System.out.println("name"+name);
		model.addAttribute("name",name);
		
		return "hello";

	}
}
