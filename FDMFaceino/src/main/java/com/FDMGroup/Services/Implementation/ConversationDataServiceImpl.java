package com.FDMGroup.Services.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.FDMGroup.DALimplementation.ConversationDALImp;
import com.FDMGroup.DALimplementation.UserDALImp;
import com.FDMGroup.DALinterfaces.ConversationDAL;
import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Services.ConversationDataService;


@Component
public class ConversationDataServiceImpl implements ConversationDataService {
	
	private ConversationDAL conversationDAL = new ConversationDALImp();
	private UserDALImp userDAL = new UserDALImp();
	
	//retrieve
	@Override
	public Conversation getConversationById(String conversationId) {
		return conversationDAL.getById(conversationId);
	}
	
	@Override
	public List<Conversation> getConversationsByUserName(String userName) {
		return conversationDAL.getAll().stream()
				.filter(con -> con.getReceivers().contains(userDAL.getByLoginName(userName)))
				.collect(Collectors.toList());
	}
	
	//update
	@Override
	public void addReceiverToConversation(User receiver, String conversationId) {
		conversationDAL.getById(conversationId).addReceiver(receiver);
	}
	@Override
	public void addMessageToConversation(Message message, String conversationId) {
		conversationDAL.getById(conversationId).addMessage(message);
	}

	//create
	@Override
	public boolean createNewConversation(Conversation con) {
		return conversationDAL.addConversation(con);
	}

	//delete
	@Override
	public void deleteConversationById(String conversationId) {
		// TODO
	}

}
