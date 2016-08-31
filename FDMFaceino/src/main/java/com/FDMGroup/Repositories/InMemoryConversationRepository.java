package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.Conversation;


public class InMemoryConversationRepository {
	static List<Conversation> conversations;
	
	public InMemoryConversationRepository(){
		conversations = new ArrayList<Conversation>();
	}
	
	public boolean addConversation(Conversation con){
		return conversations.add(con);
	}
	
	public List<Conversation> getAll(){
		return conversations;
	}
	
	public Conversation getConversationById(String id){
		for (Conversation con : conversations)
			if(con.getConversationId().equals(id))
				return con;
		return null;
	}
}
