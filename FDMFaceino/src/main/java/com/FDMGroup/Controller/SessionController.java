package com.FDMGroup.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.FDMGroup.Entities.Message;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Repositories.InMemoryUserRepository;
import com.FDMGroup.Services.LoginDataService;
import com.FDMGroup.Services.Implementation.ConversationDataServiceImpl;

@Controller
@SessionAttributes
public class SessionController {
	
	@Autowired
	LoginDataService loginDataService;
	
	private List<Message> posts = new ArrayList<Message>();
	
	@Autowired
	ConversationDataServiceImpl conversationDataService;
	
	@RequestMapping("/home")
	public String greetUser(HttpSession session, Model model, Authentication auth){
		
		session.setMaxInactiveInterval(600);
		session.setAttribute("userData", loginDataService.getUserDataFromDatabaseByName(auth.getName()));
				
		session.setAttribute("conversations", conversationDataService.getConversationsByUserName(auth.getName()));
		//session.setAttribute("conversations", Arrays.asList(new Conversation(),new Conversation(),new Conversation(),new Conversation()));
		posts.clear();//clear the list to avoid duplicate entries...
		for (User user : InMemoryUserRepository.getInstance().getAll()) {
			//posts.addAll(loginDataService.getUserDataFromDatabaseByName(auth.getName()).getContent());
			posts.addAll(user.getContent());
		}
		Collections.sort(posts);
		Collections.reverse(posts);
		
		session.setAttribute("posts", posts);
		return "homepage";
		
	}

	@RequestMapping("/redirectHome")
	public String redirectHome(){
		return "redirect:/home";
	}
}