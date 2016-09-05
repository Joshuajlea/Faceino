package com.FDMGroup.Services.Implementation;

import java.util.Arrays;
import java.util.List;

import com.FDMGroup.DALimplementation.UserDALImp;
import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Services.RegistrationDataService;

public class RegistrationDataServiceImpl implements RegistrationDataService{
	
	UserDAL userDataAcessLayer = new UserDALImp();
	
	@Override
	public List<User> getAllUser() {
		return userDataAcessLayer.getAll();
	}

	@Override
	public boolean registerUserToDatabase(User user) {		
		return userDataAcessLayer.addUser(user);
	}

	@Override
	public List<User> getNewUsers() {
		return Arrays.asList(new User("TEST1", "12345","",Arrays.asList("USER")), 
							 new User("TEST2", "12345","",Arrays.asList("USER")));
	}

	@Override
	public List<User> getActivatedUsers() {
		return null;
	}

	@Override
	public List<User> getBlockedUsers() {
		return null;
	}

}
