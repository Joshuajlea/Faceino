package com.FDMGroup;

import java.util.ArrayList;
import java.util.List;

import com.FDMGroup.Entities.User;

public class RegisterDAO {
	
	public static boolean checkIfUsernameNOTUsed(String username){
		List<User> allUsers = new ArrayList<User>(); 
		if(allUsers.parallelStream().noneMatch(a -> a.getLoginName().equals(username))){
			return true;
		}
		return false;
	}
	
	public static boolean checkPassword(String password, String rpassword){
		return password.equals(rpassword);
	}
}
