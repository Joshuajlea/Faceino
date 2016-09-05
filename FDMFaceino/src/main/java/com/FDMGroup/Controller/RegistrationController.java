package com.FDMGroup.Controller;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.thymeleaf.expression.Messages;

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
	public String checkRegistration(HttpServletRequest request, Model model, UserDetails ud){
				
		String loginUrl = "redirect:/login";
		
		String returnValue = checkUsernameForExistence(request, model, loginUrl);
		
		if(loginUrl.equals(returnValue)){
			RegisterDAO.addUser(request.getParameter("username"), request.getParameter("password"), "");			
		}
		
		
		// send verification mail here
		
		return returnValue;
	}
	
	private String checkUsernameForExistence(HttpServletRequest request, Model model, String value){
		if(RegisterDAO.checkIfUsernameNOTUsed(request.getParameter("username"))){
			model.addAttribute("errorMessage", "Username already registered");	
			return "registerpage";
		}
		return checkIfPasswordIsOK(request, model, value);
	}

	private String checkIfPasswordIsOK(HttpServletRequest request, Model model, String value){
		if(!RegisterDAO.checkPassword(request.getParameter("password"), request.getParameter("rpassword"))){
			model.addAttribute("errorMessage", "Passwords not the same");
			return "registerpage";
		}
		return checkIfMailAdressIsOk(request, model, value);
	}
	
	private String checkIfMailAdressIsOk(HttpServletRequest request, Model model, String value){
		if(!RegisterDAO.checkIfFDMMail(request.getParameter("username"))){
			model.addAttribute("errorMessage", "Username should be your fdm mail adress");
			return "registerpage";
		}
		return value;
	}}
	
	/*
																//JL\\
	
	@Autowired
	private IUserService service;
	 
	@RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
	public String confirmRegistration
	      (WebRequest request, Model model, @RequestParam("token") String token) {
	    Locale locale = request.getLocale();
	     
	    VerificationToken verificationToken = Service.getVerificationToken(token);
	    if (verificationToken == null) {
	        String message = Messages.getMessage("auth.message.invalidToken", null, locale);
	        model.addAttribute("message", message);
	        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	    }
	     
	    com.FDMGroup.Entities.User user = verificationToken.getUser();
	    Calendar cal = Calendar.getInstance();
	    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	        String messageValue = messages.getmessage("auth.message.expired", null, locale)
	        model.addAttribute("message", messageValue);
	        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	    } 
	     
	    user.setEnabled(true); 
	    service.saveRegisteredUser(user); 
	    return "redirect:/login.html?lang=" + request.getLocale().getLanguage(); 
	}	
}
*/
