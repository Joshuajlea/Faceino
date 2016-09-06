package com.FDMGroup.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.FDMGroup.Services.LoginDataService;
import com.FDMGroup.Services.Implementation.ConversationDataServiceImpl;

@Controller
@SessionAttributes
public class SessionController {
	
	@Autowired
	LoginDataService loginDataService;
	
	@Autowired
	ConversationDataServiceImpl conversationDataService;
	
	@RequestMapping("/home")
	public String greetUser(HttpSession session, Model model, Authentication auth){
		
		session.setMaxInactiveInterval(600);
		session.setAttribute("userData", loginDataService.getUserDataFromDatabaseByName(auth.getName()));
				
		session.setAttribute("conversations", conversationDataService.getConversationsByUserName(auth.getName()));
		//session.setAttribute("conversations", Arrays.asList(new Conversation(),new Conversation(),new Conversation(),new Conversation()));
		
		return "homepage";
	}

	@RequestMapping("/redirectHome")
	public String redirectHome(){
		return "redirect:/home";
	}
}
