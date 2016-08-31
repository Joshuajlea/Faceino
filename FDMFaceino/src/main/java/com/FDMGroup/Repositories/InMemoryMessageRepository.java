package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.Message;

public class InMemoryMessageRepository implements Repository<Message>{
	
	public static InMemoryMessageRepository INSTANCE;
	
	private InMemoryMessageRepository(){
	}
	
	public static synchronized InMemoryMessageRepository getInstance(){
		if(INSTANCE!=null)
			return INSTANCE;
		
		return new InMemoryMessageRepository();
	}
	
	static List<Message> messages = new ArrayList<Message>();
		
	public List<Message> getAll(){
		return messages;
	}
	
	@Override
	public boolean add(Message message) {
		return messages.add(message);
	}

	@Override
	public Message getById(String id) {
		for (Message con : messages)
			if(con.getMessageId().equals(id))
				return con;
		return null;
	}
}
