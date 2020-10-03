package com.yusuf.travel.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yusuf.travel.entity.User;
import com.yusuf.travel.repository.UserRepository;
import com.yusuf.travel.service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User user) {
		User user2 = new User();
        user2.setFirstName(user.getFirstName());
        user2.setLastName(user.getLastName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setRole("USER_ROLE");
        userRepository.save(user2);
        userRepository.flush();
        long newuserId = user2.getId();
        
        User newUser = userRepository.findById(newuserId);
        return newUser;
	}

	
}
