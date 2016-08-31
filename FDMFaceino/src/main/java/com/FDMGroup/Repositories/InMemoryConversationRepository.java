package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.Conversation;


public class InMemoryConversationRepository implements Repository<Conversation>{
	
	public static InMemoryConversationRepository INSTANCE;
	
	private InMemoryConversationRepository(){
	}
	
	public static synchronized InMemoryConversationRepository getInstance(){
		if(INSTANCE!=null)
			return INSTANCE;
		
		return new InMemoryConversationRepository();
	}
	
	private static List<Conversation> conversations = new ArrayList<Conversation>();
		
	public List<Conversation> getAll(){
		return conversations;
	}	

	@Override
	public boolean add(Conversation obj) {
		return conversations.add(obj);
	}

	@Override
	public Conversation getById(String id) {
		for (Conversation con : conversations)
			if(con.getConversationId().equals(id))
				return con;
		return null;
	}
}
