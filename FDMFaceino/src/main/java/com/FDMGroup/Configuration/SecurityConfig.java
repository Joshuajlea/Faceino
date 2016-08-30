package com.FDMGroup.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("martin.mrowiec@fdmgroup.com").password("12345").roles("USER", "ADMIN")
		.and()
			.withUser("admin").password("1234").roles("USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
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
