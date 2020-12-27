package com.devdaljeet.grademanagementsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/** Represents the security config which handles/controls access of every URLs
 * @author Daljeet Singh (Dev-Daljeet)
 * @version 1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	private LoginAccessDeniedHandler accessDeniedHandler;
	
	/** Configure the access of URLs to specific role
	 */
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests()
		.antMatchers("/list").hasRole("PROFESSOR")
		.antMatchers("/add").hasRole("PROFESSOR")
		.antMatchers("/view").hasAnyRole("PROFESSOR","STUDENT")
		.antMatchers(HttpMethod.POST, "/register").permitAll()
		.antMatchers("/", "/register", "/css/**", "/images/**", "/js/**", "/**").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedHandler(accessDeniedHandler);
	}
	
	/** Encode the password using BCryptPasswordEncoder
	 * @return bCryptPasswordEncoder An instance of class BCryptPasswordEncoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	UserDetailedServiceImpl userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
		throws Exception{
		
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
}