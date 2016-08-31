package com.FDMGroup.DALinterfaces;

import com.FDMGroup.Entities.Message;

public interface MessageRepository{
	
	public Message findByMessageId(String messageId);
	
}
