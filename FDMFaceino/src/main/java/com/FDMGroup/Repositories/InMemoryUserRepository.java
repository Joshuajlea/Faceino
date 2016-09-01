package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.User;

public class InMemoryUserRepository {
	private List<User> users = new ArrayList<User>();
	
	private static InMemoryUserRepository INSTANCE;
	
	public static synchronized InMemoryUserRepository getInstance(){
		if(INSTANCE == null)
			INSTANCE = new InMemoryUserRepository();
		
		return INSTANCE;
	}	
	
	private InMemoryUserRepository(){		
	}
	
	public boolean addUser(User usr){
		return users.add(usr);
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User getByLoginName(String id){
		for (User usr : users)
			if(usr.getLoginName().equals(id))
				return usr;
		return null;
	}
}