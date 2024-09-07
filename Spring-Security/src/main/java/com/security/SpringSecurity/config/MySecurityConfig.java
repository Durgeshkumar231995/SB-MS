package com.security.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configurable
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		//.antMatchers("/home","/login").permitAll()
		//.antMatchers("/public/**").permitAll()
		.antMatchers("/public/**").hasRole("NORMAL")
		.antMatchers("/users/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
	
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("ram").password(this.passwordEncode().encode("ram")).roles("NORMAL");
	auth.inMemoryAuthentication().withUser("Anup").password("Anup").roles("ADMIN");
	}
	/*
	 * @Bean public PasswordEncoder passwordEncode() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	
	
	@Bean
	public PasswordEncoder passwordEncode() {
	return new BCryptPasswordEncoder(10);
	}
	
	

}
