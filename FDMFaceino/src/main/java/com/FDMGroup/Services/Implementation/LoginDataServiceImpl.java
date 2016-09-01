package com.FDMGroup.Services.Implementation;

import com.FDMGroup.Services.LoginDataService;

import java.util.Arrays;

import com.FDMGroup.Entities.User;

public class LoginDataServiceImpl implements LoginDataService {

	@Override
	public User getUserDataFromDatabaseByName(String name) {
		return new User (name, "1234", "picURL", Arrays.asList("USER"));
	}

}