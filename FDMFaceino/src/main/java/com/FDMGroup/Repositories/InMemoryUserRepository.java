package com.FDMGroup.Repositories;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.FDMGroup.Entities.Message;
import com.FDMGroup.Entities.User;

public class InMemoryUserRepository {
	private List<User> users = new ArrayList<User>();

	public static InMemoryUserRepository INSTANCE;

	public static synchronized InMemoryUserRepository getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryUserRepository();

		return INSTANCE;
	}

	private InMemoryUserRepository() {
		users.add(new User("martin.mrowiec@fdmgroup.com", "12345", "", Arrays.asList("USER", "ADMIN")));
		users.add(new User("sebastian.verfers@fdmgroup.com", "12345", "", Arrays.asList("USER", "ADMIN")));
		users.add(new User("tim.bell@fdmgroup.com", "12345", "", Arrays.asList("USER", "ADMIN")));
		users.add(new User("joshua.lea@fdmgroup.com", "12345", "", Arrays.asList("USER", "ADMIN")));

		users.add(new User("arjun.kharel@fdmgroup.com", "test", "", Arrays.asList("USER", "ADMIN")));

		/*getByLoginName("arjun.kharel@fdmgroup.com")
				.addContent(new Message(getByLoginName("arjun.kharel@fdmgroup.com").getLoginName(), "Hello world"));

		getByLoginName("tim.bell@fdmgroup.com")
				.addContent(new Message(getByLoginName("tim.bell@fdmgroup.com").getLoginName(), "Hello This is timmm"));*/

		for (User u : users) {
			u.setActive(true);
			// injecting content to the user messages list
		}

	}

	public boolean addUser(User usr) {
		return users.add(usr);
	}

	public List<User> getAll() {
		return users;
	}

	public User getByLoginName(String id) {
		for (User usr : users)
			if (usr.getLoginName().equals(id))
				return usr;
		return null;
	}
}