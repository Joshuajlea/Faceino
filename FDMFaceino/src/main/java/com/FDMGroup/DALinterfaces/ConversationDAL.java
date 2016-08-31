package com.FDMGroup.DALinterfaces;

import java.util.List;

import com.FDMGroup.Entities.Conversation;

public interface ConversationDAL  {
	
	public Conversation getById(String conversationId);
	public List<Conversation> getAll();
	public boolean addConversation(Conversation con);
	
}
