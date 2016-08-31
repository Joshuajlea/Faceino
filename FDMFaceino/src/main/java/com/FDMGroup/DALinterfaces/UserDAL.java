package com.FDMGroup.DALinterfaces;

import java.util.List;

import com.FDMGroup.Entities.User;

public interface UserDAL {
	
	public User getById(String userId);
	public List<User> getAll();
	public boolean addUser(User user);	
}
