package com.FDMGroup.DALimplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.Conversation;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Entities.User;
import com.FDMGroup.Repositories.InMemoryUserRepository;

@Component
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
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User u = getByLoginName(arg0);
		return new org.springframework.security.core.userdetails.User(u.getLoginName(),u.getPassword(),Arrays.asList(new SimpleGrantedAuthority("USER")));
	}

	public List<Message> getMessagesForConversationForUser(User user, Conversation con){
		for (Conversation tempCon : user.getConversations())
			if(tempCon.equals(con))
				return tempCon.getMessages();
		
		System.out.println("The user is not part of this conversation");
		
		return new ArrayList<Message>();
	}
	
}
