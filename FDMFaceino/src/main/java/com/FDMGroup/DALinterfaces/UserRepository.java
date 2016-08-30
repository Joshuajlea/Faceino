package com.FDMGroup.DALinterfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.FDMGroup.Entities.User;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByLoginName(String loginName);

}
