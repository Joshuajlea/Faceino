package com.FDMGroup.DALinterfaces;

import com.FDMGroup.Entities.User;

public interface UserRepository {

	public User findByLoginName(String loginName);

}
