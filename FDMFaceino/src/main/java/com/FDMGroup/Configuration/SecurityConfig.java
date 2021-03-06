package com.FDMGroup.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.FDMGroup.DALinterfaces.UserDAL;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, UserDAL userData) throws Exception {
		auth.userDetailsService(userData);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/register").permitAll()
			.antMatchers("/img/**").permitAll()
			.antMatchers("/**").authenticated()
			.antMatchers("/admin").hasRole("ADMIN")
		.and()
		.formLogin()
			.loginPage("/login")
			.successForwardUrl("/redirectHome")
			.failureForwardUrl("/loginerror")
			.failureUrl("/loginerror")
			.permitAll()
		.and()
			.csrf().disable();
	}
	
}