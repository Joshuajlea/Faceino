package com.FDMGroup.DALimplementation;

import java.util.List;

import com.FDMGroup.DALinterfaces.ConversationDAL;
import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Repositories.InMemoryConversationRepository;
import com.FDMGroup.Repositories.InMemoryUserRepository;

public class ConversationDALImp implements ConversationDAL {
	
	//retrieve
	@Override
	public Conversation getById(String conversationId) {
		return InMemoryConversationRepository.getInstance().getById(conversationId);
	}
	@Override
	public List<Conversation> getAll() {
		return InMemoryConversationRepository.getInstance().getAll();
	}
	
	//create
	@Override
	public boolean addConversation(Conversation con) {
		
		for(User user : con.getReceivers()){
			InMemoryUserRepository.getInstance().getByLoginName(user.getLoginName()).addConversation(con);
		}
		return InMemoryConversationRepository.getInstance().addConversation(con);
	}
}
