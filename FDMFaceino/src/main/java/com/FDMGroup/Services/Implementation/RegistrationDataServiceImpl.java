package com.FDMGroup.Services.Implementation;


import java.util.Collection;
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
	public Collection<User> getNewUsers() {
		return userDataAcessLayer.getNUser();
	}

	@Override
	public Collection<User> getActivatedUsers() {
		return userDataAcessLayer.getEUser();
	}

	@Override
	public Collection<User> getBlockedUsers() {
		return userDataAcessLayer.getBUser();
	}

	@Override
	public boolean activateUserByName(String name) {
		return userDataAcessLayer.activateUserByName(name);
	}

	@Override
	public boolean blockUserByName(String name) {
		return userDataAcessLayer.blockUserByName(name);
	}

	@Override
	public boolean unblockUserByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
