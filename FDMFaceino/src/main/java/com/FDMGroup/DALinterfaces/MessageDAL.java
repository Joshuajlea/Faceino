package com.FDMGroup.DALinterfaces;

import java.util.List;

import com.FDMGroup.Entities.Message;

public interface MessageDAL {
	
	public Message getById(String messageId);
	public List<Message> getAll();
	public boolean addMessage(Message msg);
	
}
