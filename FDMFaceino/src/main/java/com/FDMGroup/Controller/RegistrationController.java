package com.FDMGroup.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class RegistrationController {

	@GetMapping("/register")
	public String register(){
		return "registerpage";
	}
	
	@PostMapping("/register")
	public String checkRegistration(HttpServletRequest request, Model model){
		return null;
	}
}
