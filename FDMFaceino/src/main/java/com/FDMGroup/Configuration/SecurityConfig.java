package com.FDMGroup.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.User;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, UserDAL userData) throws Exception {
		//auth.jdbcAuthentication().authoritiesByUsernameQuery("SELECT loginname , roles, active FROM USERS WHERE loginname=? AND password=?").rolePrefix("");
		
		for(User user : userData.getAll()){		
			auth.inMemoryAuthentication()
				.withUser(user.getLoginName()).password(user.getPassword()).roles("USER", "ADMIN");
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/register").permitAll()
			.antMatchers("/**").authenticated()
			.antMatchers("/admin/**").hasRole("ADMIN")
		.and()
		.formLogin()
			.loginPage("/login")
			.successForwardUrl("/home")
			.permitAll()
		.and()
			.csrf().disable();
	}
	
}
