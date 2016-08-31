package com.FDMGroup.DALimplementation;

import java.util.List;

import com.FDMGroup.DALinterfaces.InMemoryUserRepository;
import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.User;

public class UserDALImp implements UserDAL {

	@Override
	public User getById(String userId) {
		return InMemoryUserRepository.getInstance().getById(userId);
	}

	@Override
	public List<User> getAll() {
		return InMemoryUserRepository.getInstance().getAll();
	}

	@Override
	public boolean addUser(User user) {
		return InMemoryUserRepository.getInstance().addUser(user);
	}

}
