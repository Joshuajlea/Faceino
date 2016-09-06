package com.FDMGroup.Controller;

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

//public class VerificatioController {
	/*@Autowired
	//ApplicationEventPublisher eventPublisher
	 
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(
	  @ModelAttribute("user") @Valid User accountDto, 
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
	        eventPublisher(publishEvent(new OnRegistrationCompleteEvent
	          (registered, request.getLocale(), appUrl)));
	    } catch (Exception me) {
	        return new ModelAndView("emailError", "user", accountDto);
	    }
	    return new ModelAndView("successRegister", "user", accountDto);
	}

	private User createUserAccount(User accountDto) {
		return null;
	}}*/