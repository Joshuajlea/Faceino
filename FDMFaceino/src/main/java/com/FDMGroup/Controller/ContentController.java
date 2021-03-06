package com.FDMGroup.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Repositories.InMemoryOnlineRepository;
import com.FDMGroup.Repositories.InMemoryUserRepository;
import com.FDMGroup.Services.LoginDataService;
import com.FDMGroup.Services.TimeCalculatorService;
import com.FDMGroup.Services.Implementation.LoginDataServiceImpl;

@Controller

public class ContentController {

	LoginDataService loginDataService = new LoginDataServiceImpl();
	private List<Message> posts = new ArrayList<Message>();

	@Autowired
	UserDAL userDImpl;
	
	@Autowired
	TimeCalculatorService tCS; 

	@GetMapping("/posts/{text}")
	public String postStuff(Model model, HttpSession session, HttpServletRequest request,
			@PathVariable("text") String text, Authentication auth) {
		
		text = text.replace("%20", " ");
		
		userDImpl.getByLoginName(auth.getName()).getContent().add(new Message(auth.getName(), text));
		model.addAttribute("usersLoggedIn", InMemoryOnlineRepository.getInstance().getAllOnlineUser());
		sessionThings(session);
		return "frag_content :: contentFrag";
	}

	@GetMapping("/posts")
	public String postStuff(Model model, HttpSession session) {
		sessionThings(session);
		model.addAttribute("usersLoggedIn", InMemoryOnlineRepository.getInstance().getAllOnlineUser());
		return "frag_content :: contentFrag";
	}

	private void sessionThings(HttpSession session) {
		posts.clear();// clear the list to avoid duplicate entries...
		for (User user : InMemoryUserRepository.getInstance().getAll()) {
			
			List<Message> getTimeList = user.getContent();
			for(Message m : getTimeList){
				m.displayTime = tCS.getTimeBetweenAsString(m.getTime(), LocalDateTime.now());
			}
			
			posts.addAll(getTimeList);
		}
		Collections.sort(posts);
		Collections.reverse(posts);

		session.setAttribute("posts", posts);
	}
}
