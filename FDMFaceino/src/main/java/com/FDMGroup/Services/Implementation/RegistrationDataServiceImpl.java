package com.FDMGroup.Services.Implementation;

import java.util.Arrays;
import java.util.List;

import com.FDMGroup.Entities.User;
import com.FDMGroup.Services.RegistrationDataService;

public class RegistrationDataServiceImpl implements RegistrationDataService{

	@Override
	public List<User> getAllUser() {
		return Arrays.asList(new User("test@fdmgroup.com", "123", "url", Arrays.asList("USER")));
	}

}
