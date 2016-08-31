package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.User;

public class InMemoryUserRepository implements Repository<User>{
	
	public static InMemoryUserRepository INSTANCE;
	
	private InMemoryUserRepository(){
	}
	
	public static synchronized InMemoryUserRepository getInstance(){
		if(INSTANCE!=null)
			return INSTANCE;
		
		return new InMemoryUserRepository();
	}
	
	private static List<User> users = new ArrayList<User>();		
	
	@Override
	public boolean add(User obj) {
		return users.add(obj);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(String id) {
		for (User usr : users)
			if(usr.getLoginName().equals(id))
				return usr;
		return null;
	}
}