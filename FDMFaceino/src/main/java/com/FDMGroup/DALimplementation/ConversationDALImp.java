package com.FDMGroup.DALimplementation;

import java.util.List;

import com.FDMGroup.DALinterfaces.ConversationDAL;
import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Repositories.InMemoryConversationRepository;
import com.FDMGroup.Repositories.InMemoryUserRepository;

public class ConversationDALImp implements ConversationDAL {
	
	@Override
	public Conversation getById(String conversationId) {
		return InMemoryConversationRepository.getInstance().getById(conversationId);
	}

	@Override
	public List<Conversation> getAll() {
		return InMemoryConversationRepository.getInstance().getAll();
	}

	@Override
	public boolean addConversation(Conversation con) {
		
		for(String loginName : con.getReceiverNames()){
			if(InMemoryUserRepository.getInstance().getByLoginName(loginName).getConversations().size() < 4)
				InMemoryUserRepository.getInstance().getByLoginName(loginName).addConversation(con);
			else 
				System.out.println(loginName + " is already part in four group chats. Sorry!");
		}
		
		return InMemoryConversationRepository.getInstance().addConversation(con);
	}
}
