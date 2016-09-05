package com.FDMGroup.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.FDMGroup.Services.LoginDataService;
import com.FDMGroup.Services.RegistrationDataService;
import com.FDMGroup.Services.Implementation.LoginDataServiceImpl;
import com.FDMGroup.Services.Implementation.RegistrationDataServiceImpl;

@Controller
public class AdminController {

	LoginDataService loginDataService = new LoginDataServiceImpl();	
	RegistrationDataService registerDataService = new RegistrationDataServiceImpl();
	
	@GetMapping("/admin")
	public String adminMainPage(HttpSession session, Model model, Authentication auth){
		
		session.setAttribute("userData", loginDataService.getUserDataFromDatabaseByName(auth.getName()));
		
		model.addAttribute("newUsers", registerDataService.getNewUsers());
		model.addAttribute("activatedUsers", registerDataService.getActivatedUsers());
		model.addAttribute("blockedUsers", registerDataService.getBlockedUsers());
		
		return "admin/adminPage";
	}
	
	@PostMapping("/adminNewUser")
	public String enableOrBlockUser(HttpServletRequest request){
		String[] userListToEnable = request.getParameterValues("enable");
		String[] userListToBeBlocked = request.getParameterValues("block");
		
		System.out.println("To Be enabled");
		for(String s : userListToEnable){
			System.out.println(s);
		}	
		
		System.out.println("To Be blocked");
		for(String s : userListToBeBlocked){
			System.out.println(s);
		}	
		
		return "redirect:/admin";
	}
	
}
