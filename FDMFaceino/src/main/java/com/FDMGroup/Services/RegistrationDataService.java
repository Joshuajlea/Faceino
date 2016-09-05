package com.FDMGroup.Services;

import java.util.List;

import com.FDMGroup.Entities.User;

public interface RegistrationDataService {
	List<User> getAllUser();	
	boolean registerUserToDatabase(User user);
	List<User> getNewUsers();
	List<User> getActivatedUsers();
	List<User> getBlockedUsers();
}
