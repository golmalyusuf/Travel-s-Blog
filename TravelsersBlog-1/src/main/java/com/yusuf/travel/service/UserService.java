package com.yusuf.travel.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.yusuf.travel.model.User;
import com.yusuf.travel.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto userRegistrationDto);
}
