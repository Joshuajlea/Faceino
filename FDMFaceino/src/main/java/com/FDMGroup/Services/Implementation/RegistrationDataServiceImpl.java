package com.FDMGroup.Services.Implementation;

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

}
