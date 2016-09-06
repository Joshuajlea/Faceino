package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.FDMGroup.Entities.User;

public class InMemoryUserRepository {
	private List<User> users = new ArrayList<User>();
	
	public static InMemoryUserRepository INSTANCE;
	
	public static synchronized InMemoryUserRepository getInstance(){
		if(INSTANCE == null)
			INSTANCE = new InMemoryUserRepository();
		
		return INSTANCE;
	}	
	
	private InMemoryUserRepository(){	
		users.add(new User("martin.mrowiec@fdmgroup.com", "12345", "", Arrays.asList("USER", "ADMIN")));
		users.add(new User("sebastian.verfers@fdmgroup.com", "12345", "", Arrays.asList("USER", "ADMIN")));
		users.add(new User("tim.bell@fdmgroup.com", "12345", "", Arrays.asList("USER", "ADMIN")));
		users.add(new User("joshua.lea@fdmgroup.com", "12345", "", Arrays.asList("USER", "ADMIN")));
		
		users.add(new User("arjun.kharel@fdmgroup.com", "test", "", Arrays.asList("USER", "ADMIN")));
		
		for(User u : users){
			u.setActive(true);
		}
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