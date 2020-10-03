package com.yusuf.travel.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		System.out.println("29 SecurityCOnfig.java "); 
		auth.userDetailsService(userDetailsService);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		System.out.println("35 SecurityCOnfig.java ");
		http.authorizeRequests().antMatchers("/user").hasRole("USER_ROLE")
		.antMatchers("/").permitAll().antMatchers("/registration").permitAll().and()
		.formLogin()
		.loginPage("/index")
        .defaultSuccessUrl("/home")
        .failureUrl("/login?error")
        .permitAll();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		System.out.println("48 SecurityCOnfig.java ");
		return NoOpPasswordEncoder.getInstance();
	};
}