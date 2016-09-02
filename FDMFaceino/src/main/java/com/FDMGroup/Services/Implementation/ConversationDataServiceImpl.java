package com.FDMGroup.Services.Implementation;

import com.FDMGroup.DALimplementation.ConversationDALImp;
import com.FDMGroup.DALinterfaces.ConversationDAL;
import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Services.ConversationDataService;

public class ConversationDataServiceImpl implements ConversationDataService {
	
	private ConversationDAL conversationDAL = new ConversationDALImp();
	
	@Override
	public Conversation getConversationById(String conversationId) {
		return conversationDAL.getById(conversationId);
	}

	@Override
	public void addReceiverToConversation(User receiver, String conversationId) {
		conversationDAL.getById(conversationId).addReceiver(receiver);
	}

	@Override
	public void addMessageToConversation(Message message, String conversationId) {
		conversationDAL.getById(conversationId).addMessage(message);
	}

	@Override
	public boolean createNewConversation(Conversation con) {
		return conversationDAL.addConversation(con);
	}

	@Override
	public void deleteConversationById(String conversationId) {
		// TODO
	}

}
