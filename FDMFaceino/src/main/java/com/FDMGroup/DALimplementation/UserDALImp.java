package com.FDMGroup.DALimplementation;

import java.util.List;

import javax.persistence.Column;

import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Repositories.InMemoryUserRepository;

public class UserDALImp implements UserDAL {

	@Override
	public User getByLoginName(String userId) {
		return InMemoryUserRepository.getInstance().getByLoginName(userId);
	}

	@Override
	public List<User> getAll() {
		return InMemoryUserRepository.getInstance().getAll();
	}

	@Override
	public boolean addUser(User user) {
		return InMemoryUserRepository.getInstance().addUser(user);
	}

	@Column(name = "enabled")
    private boolean enabled;
     
    public UserDALImp() {
        super();
        this.enabled=false;
}
}
