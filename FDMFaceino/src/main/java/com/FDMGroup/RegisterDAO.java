package com.FDMGroup;

public class RegisterDAO {
	
	public static boolean checkUsername(String username){
		
		return false;
	}
	
	public static boolean checkPassword(String password, String rpassword){
		return password.equals(rpassword);
	}
}
