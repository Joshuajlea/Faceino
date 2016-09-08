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
		
		List<User> receiver2 = new ArrayList<User>();
		receiver2.add(InMemoryUserRepository.getInstance().getByLoginName("tim.bell@fdmgroup.com"));
		receiver2.add(InMemoryUserRepository.getInstance().getByLoginName("sebastian.verfers@fdmgroup.com"));
		Conversation con2 = new Conversation(receiver2);
		con2.addMessage(new Message("tim.bell@fdmgroup.com", "Tim here, how are you"));
		con2.addMessage(new Message("sebastian.verfers@fdmgroup.com", "Good, thanks"));
		con2.addMessage(new Message("tim.bell@fdmgroup.com", "cool, dude, this works"));
		conversations.add(con2);
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
