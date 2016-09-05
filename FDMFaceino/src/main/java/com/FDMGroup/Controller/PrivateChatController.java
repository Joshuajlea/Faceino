package com.FDMGroup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.ConversationMessage;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Services.Implementation.ConversationDataServiceImpl;

@Controller
public class PrivateChatController {
	
	private SimpMessagingTemplate template;
	
	@Autowired
	ConversationDataServiceImpl conversationDataService;
	
	@MessageMapping("/private")
	@SendToUser("/topic/messages")
	public Message sendPrivateMessage (ConversationMessage conMessage) throws Exception {
		Message newMessage = new Message(conMessage.getSender(), conMessage.getContent());
		// add message to Conversation database
		conversationDataService.addMessageToConversation(newMessage, conMessage.getConversationId());
		// send message to all users in conversation
		Conversation con = conversationDataService.getConversationById(conMessage.getConversationId());
		con.getReceivers().forEach(user -> this.template.convertAndSendToUser(user.getLoginName(), "/topic/messages", conMessage));
		return  newMessage;
	}

}
