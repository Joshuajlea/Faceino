package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.Conversation;


public class InMemoryConversationRepository {
	public List<Conversation> conversations = new ArrayList<Conversation>();
	
	private static InMemoryConversationRepository INSTANCE;
	
	public static synchronized InMemoryConversationRepository getInstance(){
		if(INSTANCE == null)
			INSTANCE = new InMemoryConversationRepository();
		
		return INSTANCE;
	}	
	
	private InMemoryConversationRepository(){	
	}
	
	public boolean addConversation(Conversation con){
		return conversations.add(con);
	}
	
	public List<Conversation> getAll(){
		return conversations;
	}
	
	public Conversation getById(String id){
		for (Conversation con : conversations)
			if(con.getConversationId().equals(id))
				return con;
		return null;
	}
}
