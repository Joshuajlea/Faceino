package com.FDMGroup.Controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.FDMGroup.Entities.User;
import com.FDMGroup.Verification.OnRegistrationCompleteEvent;

public class VerificationController {

	
	// JL 02/09/16
	//This should deal with the registration page that handles the token and URL that the user is sent 
	 
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(
	  @ModelAttribute("user") @Valid User accountDto, 
	  BindingResult result, 
	  WebRequest request, 
	  Errors errors) {
	    if (result.hasErrors()) {
	        return new ModelAndView("registration", "user", accountDto);
	    }
	     
	    User registered = addUser(accountDto);
	    if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
	    try {
	        String appUrl = request.getContextPath();
	        eventPublisher(publishEvent(new OnRegistrationCompleteEvent
	          (registered, request.getLocale(), appUrl)));
	    } catch (Exception me) {
	        return new ModelAndView("emailError", "user", accountDto);
	    }
	    return new ModelAndView("successRegister", "user", accountDto);
	}

	private User addUser(User accountDto) {
		 //TODO Auto-generated method stub
		return null;
	}

	private void eventPublisher(Object publishEvent) {
		// TODO Auto-generated method stub
		
	}

	private Object publishEvent(OnRegistrationCompleteEvent onRegistrationCompleteEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	public com.FDMGroup.Entities.User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Calendar getExpiryDate() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}



