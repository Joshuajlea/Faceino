package com.FDMGroup.Services.Implementation;

import com.FDMGroup.Services.LoginDataService;

import tempFiles.User;

public class LoginDataServiceImpl implements LoginDataService {

	@Override
	public User getUserDataFromDatabaseByName(String name) {
		return new User (name);
	}

}
