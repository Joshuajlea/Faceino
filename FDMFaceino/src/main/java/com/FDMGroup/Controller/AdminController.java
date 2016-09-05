package com.FDMGroup.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FDMGroup.Services.LoginDataService;
import com.FDMGroup.Services.RegistrationDataService;
import com.FDMGroup.Services.Implementation.LoginDataServiceImpl;
import com.FDMGroup.Services.Implementation.RegistrationDataServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	LoginDataService loginDataService = new LoginDataServiceImpl();	
	RegistrationDataService registerDataService = new RegistrationDataServiceImpl();
	
	@GetMapping("/interface")
	public String enableUsers(HttpSession session, Model model, Authentication auth){
		
		session.setAttribute("userData", loginDataService.getUserDataFromDatabaseByName(auth.getName()));
		
		model.addAttribute("newUsers", registerDataService.getNewUsers());
		model.addAttribute("activatedUsers", registerDataService.getActivatedUsers());
		model.addAttribute("blockedUsers", registerDataService.getBlockedUsers());
		
		return "admin/adminPage";
	}
	
}
