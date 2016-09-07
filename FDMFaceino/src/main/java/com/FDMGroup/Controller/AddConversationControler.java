package com.FDMGroup.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Services.ConversationDataService;

@Controller
public class AddConversationControler {
	
	@Autowired
	ConversationDataService conversationData;
	@Autowired
	UserDAL userData;
	
	
	@PostMapping("/conversation")
	public String addConversation(@RequestParam(value = "myArray[]") String[] receivers, HttpSession session, Authentication auth) {
		// create Conversation and store in database
		conversationData.createNewConversation(new Conversation(convertToUserList(receivers)));
		// update session attribute
		updateSessionAttribute(session, auth);
		return "frag_chat :: chat";
	}
	
	@GetMapping("/allusers")	
	public @ResponseBody List<String> getAllRegisteredUsers(Model model) {
		return userData.getAll().stream().map(a -> a.getLoginName()).collect(Collectors.toList());
	}
	
	@GetMapping("/conversation")
	public String addConversation() {
		return "frag_chat :: chat";
	}

	private void updateSessionAttribute(HttpSession session, Authentication auth) {
		session.setAttribute("conversations", conversationData.getConversationsByUserName(auth.getName()));
	}
	
	
	
	private List<User> convertToUserList(String[] receivers) {
		List<User> tempList = new ArrayList<User>();
		for(int i = 0 ; i<receivers.length; i++){
			tempList.add(userData.getByLoginName(receivers[i]));
		}
		return tempList;
	}

}
