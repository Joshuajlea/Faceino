package com.FDMGroup.DALimplementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
		List<SimpleGrantedAuthority> authoritiesList = new ArrayList<SimpleGrantedAuthority>();
		for(String role : u.getRoles()){
			authoritiesList.add(new SimpleGrantedAuthority(role));
		}
		return new org.springframework.security.core.userdetails.User(	u.getLoginName(),
																		u.getPassword(),
																		u.isActive(),
																		true,
																		true,
																		!u.isBlocked(),
																		authoritiesList);
	}

	public List<Message> getMessagesForConversationForUser(User user, Conversation con){
		for (Conversation tempCon : user.getConversations())
			if(tempCon.equals(con))
				return tempCon.getMessages();
		
		System.out.println("The user is not part of this conversation");
		
		return new ArrayList<Message>();
	}
	//Dal implementation for admin page to be populated with users info 
	
	
	public Collection getNUser() {
		return getAll().stream().filter(a -> a.isActive() == false).collect(Collectors.toList());
	}

	public Collection getEUser() {
		return getAll().stream().filter(a -> a.isActive() == true).collect(Collectors.toList());
	}

	public Collection getBUser() {
		return getAll().stream().filter(a -> a.isBlocked() == true).collect(Collectors.toList());
	}

}

