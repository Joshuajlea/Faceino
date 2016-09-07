package com.FDMGroup.Repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryOnlineRepository {
	private static InMemoryOnlineRepository instance = null;
	
	private static List<String> onlineUser = new ArrayList<String>();
	
	protected InMemoryOnlineRepository(){
		
	}
	public static InMemoryOnlineRepository getInstance(){
		if(instance == null){
			instance = new InMemoryOnlineRepository();
		}
		
		return instance;
	}
	
	public void addUser(String loginname){
		onlineUser.add((loginname.split("@"))[0]);
		Collections.sort(onlineUser);
	}
	
	public void removeUser(String loginname){
		onlineUser.remove((loginname.split("@"))[0]);
	}
	
	public List<String> getAllOnlineUser(){
		return onlineUser;
	}
}
