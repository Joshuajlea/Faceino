package com.FDMGroup.DALinterfaces;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.FDMGroup.Entities.User;

public interface UserDAL extends UserDetailsService {
	
	public User getByLoginName(String userId);
	public List<User> getAll();
	public boolean addUser(User user);	
	
	public Collection<User> getNUser();
	public Collection<User> getEUser();
	public Collection<User> getBUser();
	
	boolean activateUserByName(String name);
	boolean blockUserByName(String name);
}
