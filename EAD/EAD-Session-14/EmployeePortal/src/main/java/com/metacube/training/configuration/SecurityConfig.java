package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
		 
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		  auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance())
		 .usersByUsernameQuery(
		  "select email_id as username,password,enabled from employee where email_id=?")
		 .authoritiesByUsernameQuery(
		  "select e.email_id, r.user_role from role r inner join employee e on r.emp_code = e.emp_code"
		  + " where e.email_id = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/*")
		.access("hasRole('ROLE_ADMIN')")
		.antMatchers("/employee/*")
		.access("hasRole('ROLE_EMPLOYEE')")
		.and()
		.formLogin()
		.loginPage("/login").loginProcessingUrl("/login")
		.defaultSuccessUrl("/default").usernameParameter("username")
		.passwordParameter("password").and().logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login?logout").and().exceptionHandling()
		.accessDeniedPage("/error").and().csrf();
	}
}
