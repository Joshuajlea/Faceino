package com.FDMGroup.DALimplementation;

import java.util.List;

import com.FDMGroup.DALinterfaces.ConversationDAL;
import com.FDMGroup.DALinterfaces.InMemoryConversationRepository;
import com.FDMGroup.Entities.Conversation;

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
		return InMemoryConversationRepository.getInstance().addConversation(con);
	}

}
