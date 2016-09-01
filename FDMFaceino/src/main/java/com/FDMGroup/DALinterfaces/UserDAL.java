package com.FDMGroup.DALinterfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.FDMGroup.Entities.User;

public interface UserDAL extends UserDetailsService {
	
	public User getByLoginName(String userId);
	public List<User> getAll();
	public boolean addUser(User user);	
	
	
}
