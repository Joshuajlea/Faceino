package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.Message;

public class InMemoryMessageRepository {
	static List<Message> messages;
	
	public InMemoryMessageRepository(){
		messages = new ArrayList<Message>();
	}
	
	public boolean addMessage(Message con){
		return messages.add(con);
	}
	
	public List<Message> getAll(){
		return messages;
	}
	
	public Message getMessageById(String id){
		for (Message con : messages)
			if(con.getMessageId().equals(id))
				return con;
		return null;
	}
}
