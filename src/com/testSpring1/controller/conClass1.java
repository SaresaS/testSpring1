package com.testSpring1.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class conClass1 {
	
	@RequestMapping("/welcome")
	
	public ModelAndView helloWorld(HttpServletRequest request,
			HttpServletResponse response)
	{	//get cookies from client pc and puts in array
		Cookie [] c =request.getCookies();
		//default temp in F
		String temp="F";
		//is cookie array has elements get value and return
		if (c != null){
			if (c.length>1){
				temp = c[1].getValue();			}
		}else{
			Cookie tempCookie = new Cookie("temp","F");
			response.addCookie(tempCookie);
		}
		
		//return to welcome.html displaying message temp
	return new ModelAndView("welcome","message",temp);
		
	}
@RequestMapping("/changeTemp")
	
	public ModelAndView changeTemp(HttpServletRequest request,
			HttpServletResponse response, @RequestParam ("temp" )String t){
		Cookie ar [] = request.getCookies();
		
		if (ar != null){
			Cookie c = new Cookie("temp", t);
			response.addCookie(c);
		}
		return new ModelAndView("welcome","message",t);	
}
		
}
