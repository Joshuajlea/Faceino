package com.FDMGroup.Services;

import com.FDMGroup.Entities.User;

public interface LoginDataService {
	
	User getUserDataFromDatabaseByName(String name);

}