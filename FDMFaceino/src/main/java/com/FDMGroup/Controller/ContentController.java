package com.FDMGroup.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.FDMGroup.Entities.Message;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Services.LoginDataService;
import com.FDMGroup.Services.Implementation.LoginDataServiceImpl;

@Controller

public class ContentController {

	LoginDataService loginDataService = new LoginDataServiceImpl();

	@PostMapping("/postcontent")
	public String postContent(HttpServletRequest request, Authentication auth) {

		System.out.println("Request param: " + request.getParameter("content"));

		String tempUser = auth.getName().toString();
		loginDataService.getUserDataFromDatabaseByName(tempUser)
				.addContent(new Message(tempUser, request.getParameter("content")));

		return "redirect:/home";
	}
	
	@RequestMapping(value = "/guests", method = RequestMethod.GET)
	public String showGuestList(Model model, Authentication auth,HttpServletRequest request) {
		String tempUser = auth.getName().toString();
	    model.addAttribute("posts", loginDataService.getUserDataFromDatabaseByName(tempUser)
				.addContent(new Message(tempUser, request.getParameter("content"))));

	    return "results :: resultsList";
	}
}
