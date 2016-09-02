package com.FDMGroup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Services.Implementation.ConversationDataServiceImpl;

public class PrivateChatController {
	
	private SimpMessagingTemplate template;
	
	@Autowired
	ConversationDataServiceImpl dataService;
	
	@MessageMapping("/private")
	@SendToUser("/topic/messages")
	public Message sendPrivateMessage (String conversationId, Message newMessage) throws Exception {
		// add message to Conversation database
		dataService.addMessageToConversation(newMessage, conversationId);
		// send message to all users in conversation
		Conversation con = dataService.getConversationById(conversationId);
		con.getReceivers().forEach(user -> this.template.convertAndSendToUser(user.getLoginName(), "/topic/messages", newMessage));
		return  newMessage;
	}
	
	@RequestMapping("/senduser")
	public String privateChat(String conversationId, Model model){
		// load conversation from Database
		model.addAttribute("conversation", dataService.getConversationById(conversationId));
		return "privatechat";
	}

}
