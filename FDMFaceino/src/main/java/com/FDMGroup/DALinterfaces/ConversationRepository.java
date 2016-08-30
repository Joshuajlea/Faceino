package com.FDMGroup.DALinterfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.FDMGroup.Entities.Conversation;

public interface ConversationRepository extends MongoRepository<Conversation, String> {
	
	public Conversation findByConversationId(String conversationId);
	
}
