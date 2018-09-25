package com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth)
throws Exception {

auth.inMemoryAuthentication().withUser("ramjilal")
.password("{noop}123456").roles("ADMIN");
auth.inMemoryAuthentication().withUser("admin").password("{noop}123456")
.roles("ADMIN");
auth.inMemoryAuthentication().withUser("E18/1025").password("{noop}123456")
.roles("EMPLOYEE");

}

@Override
protected void configure(HttpSecurity http) throws Exception {

http.authorizeRequests().antMatchers("/admin/*")
.access("hasRole('ROLE_ADMIN')")
.antMatchers("/employee/*")
.access("hasRole('ROLE_EMPLOYEE')")
.and()
.formLogin()
. loginPage("/login").loginProcessingUrl("/login")
.defaultSuccessUrl("/default").usernameParameter("username")
.passwordParameter("password").and().logout()
.logoutUrl("/logout")
.logoutSuccessUrl("/login?logout").and().exceptionHandling()
.accessDeniedPage("/error").and().csrf();

}

}
