package com.vm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		
		/*auth.inMemoryAuthentication()
		.withUser("saiteja")
		.password("ashok")
		.roles("USER")
		.and()
		.withUser("sai")
		.password("gupta")
		.roles("ADMIN");*/
		
		auth.jdbcAuthentication()
		.dataSource(dataSource); //we have spring security to point to the h2 db
		/*.withDefaultSchema()  //users n authorities
		.withUser(
				User.withUsername("user").password("userpwd").roles("USER")
				)
		.withUser(
				User.withUsername("admin").password("adminpwd").roles("ADMIN")
				);*/

	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")//please allow access to /user url to both user and admin
		.antMatchers("/").permitAll()
		//.hasAnyRole("_","_")
		.and()
		.formLogin();
	}
}
