package com.FDMGroup.Services;

import java.util.Collection;
import java.util.List;

import com.FDMGroup.Entities.User;

public interface RegistrationDataService {
	List<User> getAllUser();	
	boolean registerUserToDatabase(User user);
	Collection<User> getNewUsers();
	Collection<User> getActivatedUsers();
	Collection<User> getBlockedUsers();
	boolean activateUserByName(String name);
	boolean blockUserByName(String name);
}
