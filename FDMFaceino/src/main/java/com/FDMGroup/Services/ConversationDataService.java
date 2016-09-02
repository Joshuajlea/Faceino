package com.FDMGroup.Services;


import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Entities.User;

public interface ConversationDataService {
	
	boolean createNewConversation(Conversation con);
	void addReceiverToConversation(User receivers, String conversationId); 
	void addMessageToConversation(Message message, String conversationId);
	void deleteConversationById(String conversationId);
	Conversation getConversationById(String conversationId);
}
