package com.FDMGroup.Controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Services.LoginDataService;
import com.FDMGroup.Services.Implementation.LoginDataServiceImpl;

@Controller
@SessionAttributes
public class SessionController {
	
	LoginDataService loginDataService = new LoginDataServiceImpl();
	@Autowired
	UserDAL userDImpl;
	
	
	@RequestMapping("/home")
	public String greetUser(HttpSession session, Model model, Authentication auth){
		
		session.setMaxInactiveInterval(600);
		session.setAttribute("userData", loginDataService.getUserDataFromDatabaseByName(auth.getName()));
		
		List<Message> allMessages = userDImpl.getByLoginName(auth.getName()).getContent();
		Collections.reverse(allMessages);
		model.addAttribute("messages", allMessages);
		
		
		return "homepage";
	}

	@RequestMapping("/redirectHome")
	public String redirectHome(){
		return "redirect:/home";
	}
}
