package com.FDMGroup.DALinterfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.FDMGroup.Entities.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
	
	public Message findByMessageId(String messageId);
	
}
