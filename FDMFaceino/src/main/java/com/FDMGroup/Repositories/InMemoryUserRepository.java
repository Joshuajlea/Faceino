package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.User;

public class InMemoryUserRepository {
	static List<User> users;
	
	public InMemoryUserRepository(){
		users = new ArrayList<User>();
	}
	
	public boolean addConversation(User usr){
		return users.add(usr);
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User getConversationById(String id){
		for (User usr : users)
			if(usr.getLoginName().equals(id))
				return usr;
		return null;
	}
}