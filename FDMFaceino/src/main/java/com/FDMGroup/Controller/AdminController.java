package com.FDMGroup.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		
		if(request.getParameterMap().containsKey("enable")){
			String[] userListToEnable = request.getParameterValues("enable");
			for(String s : userListToEnable){
				registerDataService.activateUserByName(s);
			}	
		}

		if(request.getParameterMap().containsKey("block")){
			String[] userListToBeBlocked = request.getParameterValues("block");
			for(String s : userListToBeBlocked){
				registerDataService.blockUserByName(s);
			}	
		}
		
		return "redirect:/admin";
	}
	
	@PostMapping("/adminBlockUser")
	public String blockEnabledUser(HttpServletRequest request){
		
		if(request.getParameterMap().containsKey("block")){
			String[] userListToBeBlocked = request.getParameterValues("block");
			for(String s : userListToBeBlocked){
				registerDataService.blockUserByName(s);
			}	
		}		
		
		return "redirect:/admin";
	}
	
	@PostMapping("/adminUnblockUser")
	public String unblockEnabledUser(HttpServletRequest request){
		
		if(request.getParameterMap().containsKey("block")){
			String[] userListToBeBlocked = request.getParameterValues("block");
			for(String s : userListToBeBlocked){
				registerDataService.unblockUserByName(s);
			}	
		}		
		
		return "redirect:/admin";
	}
}
