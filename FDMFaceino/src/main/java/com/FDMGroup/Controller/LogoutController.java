package com.FDMGroup.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.FDMGroup.Repositories.InMemoryOnlineRepository;

@Controller
public class LogoutController {

	@GetMapping("/logoutOut")
	public String logout(Authentication auth) {
		InMemoryOnlineRepository.getInstance().removeUser(auth.getName());
	    return "redirect:/logout";
	}
}
