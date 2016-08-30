package com.FDMGroup.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class SessionController {
	
	
	@RequestMapping("/home")
	public String greetUser(HttpSession session, Model model, Authentication auth){
		
		session.setMaxInactiveInterval(300);
		
		if(session.isNew()){
			model.addAttribute("message", "Welcome for the first time");
		}

		session.setAttribute("loginname", auth.getName());
		
		return "homepage";
	}

	
	@GetMapping("/login")
	public String login(){
		return "loginpage";
	}
	
}
