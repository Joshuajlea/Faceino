package com.FDMGroup.DALinterfaces;

import com.FDMGroup.Entities.Conversation;

public interface ConversationRepository {
	
	public Conversation findByConversationId(String conversationId);
	
}
