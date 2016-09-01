package com.FDMGroup.Controller;

import java.security.MessageDigest;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.FDMGroup.RegisterDAO;
import com.FDMGroup.Entities.User;

import Verification.VerificationToken;

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
	
	// verification controller below 
	
	@Autowired
	public ApplicationEventPublisher EventPublisher;
	 
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(
	  @ModelAttribute("user") @Valid org.springframework.boot.autoconfigure.security.SecurityProperties.User accountDto, 
	  BindingResult result, 
	  WebRequest request, 
	  Errors errors) {
	    if (result.hasErrors()) {
	        return new ModelAndView("registration", "user", accountDto);
	    }
	     
	    User registered = createUserAccount(accountDto);
	    if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
	    try {
	        String appUrl = request.getContextPath();
	        EventPublisher.publishEvent(new OnRegistrationCompleteEvent
	          (registered, request.getLocale(), appUrl));
	    } catch (Exception me) {
	        return new ModelAndView("emailError", "user", accountDto);
	    }
	    return new ModelAndView("successRegister", "user", accountDto);
	}

	private User createUserAccount(org.springframework.boot.autoconfigure.security.SecurityProperties.User accountDto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Autowired
	private IUserService service;
	 
	@RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
	public String confirmRegistration
	      (WebRequest request, Model model, @RequestParam("token") String token) {
	    Locale locale = request.getLocale();
	     
	    VerificationToken verificationToken = service.getVerificationToken(token);
	    if (verificationToken == null) {
	        String message = messages.getMessage("auth.message.invalidToken", null, locale);
	        model.addAttribute("message", message);
	        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	    }
	     
	    User user = verificationToken.getUser();
	    Calendar cal = Calendar.getInstance();
	    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	        String messageValue = MessageDigest.getMessage("auth.message.expired", null, locale)
	        model.addAttribute("message", messageValue);
	        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	    } 
	     
	    user.setEnabled(true); 
	    service.saveRegisteredUser(user); 
	    return "redirect:/login.html?lang=" + request.getLocale().getLanguage(); 
	}
	
}
