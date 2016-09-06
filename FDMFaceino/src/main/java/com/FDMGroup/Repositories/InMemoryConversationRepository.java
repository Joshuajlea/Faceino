package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Entities.User;


public class InMemoryConversationRepository {
	public List<Conversation> conversations = new ArrayList<Conversation>();
	
	private static InMemoryConversationRepository INSTANCE;
	
	public static synchronized InMemoryConversationRepository getInstance(){
		if(INSTANCE == null)
			INSTANCE = new InMemoryConversationRepository();
		
		return INSTANCE;
	}	
	
	private InMemoryConversationRepository(){	
		// default conversation only for testing
		List<User> receiver = InMemoryUserRepository.getInstance().getAll();
		Conversation con = new Conversation(receiver);
		con.addMessage(new Message("sebastian.verfers@fdmgroup.com", "das ist ein test"));
		conversations.add(con);
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
