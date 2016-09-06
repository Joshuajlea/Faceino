package com.FDMGroup.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class LoginController {

	@GetMapping("/login")
	public String login(){
		return "loginpage";
	}
/*
	@RequestMapping("/login?error")
	public String errorPage(){
		System.out.println("ERROR");
		return "redirect:/login";
	}
	*/
}