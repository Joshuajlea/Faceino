package com.FDMGroup.Services.Implementation;

import org.springframework.stereotype.Component;

import com.FDMGroup.DALimplementation.UserDALImp;
import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Services.LoginDataService;

@Component
public class LoginDataServiceImpl implements LoginDataService {

	UserDAL userDataAcessLayer = new UserDALImp();
	
	@Override
	public User getUserDataFromDatabaseByName(String name) {
		return userDataAcessLayer.getByLoginName(name);
	}

}