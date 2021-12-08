//package com.agent.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class AgentSecurityClass extends WebSecurityConfigurerAdapter {
//
//	// use for user creation
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication().withUser("nikhil").password(this.passwordEncoder().encode("nikhil123"))
//				.roles("agent");
//
//	}
//
//	// use for Align roles and resources
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().
//
//				antMatchers("/public/**").permitAll().antMatchers("/agentApi/**").hasRole("agent").anyRequest()
//				.authenticated().and().httpBasic();
//
//		http.csrf().disable();
//
//	}// end of http Security
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//}// end class
