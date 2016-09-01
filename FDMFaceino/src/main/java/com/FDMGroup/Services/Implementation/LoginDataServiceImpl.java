package com.FDMGroup.Services.Implementation;

import com.FDMGroup.Services.LoginDataService;

import java.util.Arrays;

import com.FDMGroup.DALimplementation.UserDALImp;
import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.User;

public class LoginDataServiceImpl implements LoginDataService {

	UserDAL userDataAcessLayer = new UserDALImp();
	
	@Override
	public User getUserDataFromDatabaseByName(String name) {
		return userDataAcessLayer.getByLoginName(name);
	}

}