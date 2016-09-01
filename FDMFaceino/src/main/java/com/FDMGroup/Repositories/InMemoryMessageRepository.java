package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.Message;

public class InMemoryMessageRepository {
	private List<Message> messages = new ArrayList<Message>();
	
	private static InMemoryMessageRepository INSTANCE;
	
	public static synchronized InMemoryMessageRepository getInstance(){
		if(INSTANCE != null)
			INSTANCE = new InMemoryMessageRepository();
		
		return INSTANCE;
	}	
	
	private InMemoryMessageRepository(){		
	}
		
	public boolean addMessage(Message con){
		return messages.add(con);
	}
	
	public List<Message> getAll(){
		return messages;
	}
	
	public Message getById(String id){
		for (Message con : messages)
			if(con.getMessageId().equals(id))
				return con;
		return null;
	}
}
