package com.FDMGroup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.ConversationMessage;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Services.Implementation.ConversationDataServiceImpl;

@Controller
public class PrivateChatController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	ConversationDataServiceImpl conversationDataService;
	
	@MessageMapping("/private")
	public Message sendPrivateMessage (ConversationMessage conMessage) throws Exception {
		Message newMessage = new Message(conMessage.getSender(), conMessage.getContent());
		// add message to Conversation database
		conversationDataService.addMessageToConversation(newMessage, conMessage.getConversationId());
		// send message to all users in conversation
		Conversation con = conversationDataService.getConversationById(conMessage.getConversationId());
		con.getReceivers().forEach(user -> template.convertAndSendToUser(user.getLoginName(), "/queue/messages", conMessage));
		return conMessage;
	}

}
