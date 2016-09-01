package com.FDMGroup;

import java.util.List;

import com.FDMGroup.Entities.User;
import com.FDMGroup.Services.RegistrationDataService;
import com.FDMGroup.Services.Implementation.RegistrationDataServiceImpl;

public class RegisterDAO {
	
	static RegistrationDataService regDS = new RegistrationDataServiceImpl();
	
	public static boolean checkIfUsernameNOTUsed(String username){
		List<User> allUsers = regDS.getAllUser();
		
		if(!allUsers.parallelStream().anyMatch(a -> a.getLoginName().equals(username))){
			return false;
		}
		return true;
	}
	
	public static boolean checkIfFDMMail(String username){
		String[] split = username.split("@");
		return split[1].equals("fdmgroup.com");
	}
	
	public static boolean checkPassword(String password, String rpassword){
		return password.equals(rpassword);
	}
	
	public static boolean addUser(String loginname, String password, String url){
		return regDS.registerUserToDatabase(new User(loginname, password, url));
	}
}
