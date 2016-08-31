package com.FDMGroup.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.FDMGroup.RegisterDAO;

@Controller
@SessionAttributes
public class RegistrationController {

	@GetMapping("/register")
	public String register(Model model){
		String errorMessage = "";
		model.addAttribute("errorMessage", errorMessage);
		return "registerpage";
	}
	
	@PostMapping("/register")
	public String checkRegistration(HttpServletRequest request, Model model){
				
		String returnValue = "redirect:/login";
		
		returnValue = checkUsernameForExistence(request, model, returnValue);
		returnValue = checkIfPasswordIsOK(request, model, returnValue);
		returnValue = checkIfMailAdressIsOk(request, model, returnValue);
		
		// send verification mail here
		
		return returnValue;
	}
	
	private String checkUsernameForExistence(HttpServletRequest request, Model model, String value){
		if(RegisterDAO.checkIfUsernameNOTUsed(request.getParameter("username"))){
			model.addAttribute("errorMessage", "Username already registered");	
			return "registerpage";
		}
		return value;
	}

	private String checkIfPasswordIsOK(HttpServletRequest request, Model model, String value){
		if(!RegisterDAO.checkPassword(request.getParameter("password"), request.getParameter("rpassword"))){
			model.addAttribute("errorMessage", "Passwords not the same");
			return "registerpage";
		}
		return value;
	}
	
	private String checkIfMailAdressIsOk(HttpServletRequest request, Model model, String value){
		if(!RegisterDAO.checkIfFDMMail(request.getParameter("username"))){
			model.addAttribute("errorMessage", "Username should be your fdm mail adress");
			return "registerpage";
		}
		return value;
	}
	
}