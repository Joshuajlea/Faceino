package com.FDMGroup.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.FDMGroup.Services.LoginDataService;
import com.FDMGroup.Services.Implementation.LoginDataServiceImpl;

@Controller
@SessionAttributes
public class SessionController {
	
	LoginDataService loginDataService = new LoginDataServiceImpl();
	
	@RequestMapping("/home")
	public String greetUser(HttpSession session, Model model, Authentication auth){
		
		session.setMaxInactiveInterval(600);
		session.setAttribute("userData", loginDataService.getUserDataFromDatabaseByName(auth.getName()));
		
		return "homepage";
	}

	
	@GetMapping("/login")
	public String login(){
		return "loginpage";
	}
	
	@RequestMapping("/redirectHome")
	public String redirectHome(){
		return "redirect:/home";
	}
	
}
