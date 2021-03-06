package com.yusuf.travel.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.yusuf.travel.model.Locations;
import com.yusuf.travel.model.Post;
import com.yusuf.travel.model.Privacy;
import com.yusuf.travel.model.User;
import com.yusuf.travel.repository.LocationsRepository;
import com.yusuf.travel.repository.PostStatusRepository;
import com.yusuf.travel.repository.PrivacyRepository;
import com.yusuf.travel.repository.UserRepository;
import com.yusuf.travel.service.PostService;
import com.yusuf.travel.web.dto.PostStatusDto;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	UserRepository userRepository; 
	
	@Autowired
	LocationsRepository locationsRepository;
	
	@Autowired
	PrivacyRepository privacyRepository;
	
	@Autowired
	PostStatusRepository postStatusRepository; 
	
	@Override
	public Post save(PostStatusDto postStatusDto) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    User user = userRepository.findByEmail(userDetails.getUsername()); 
		Optional<Locations> locations = locationsRepository.findById(postStatusDto.getLocationPointId());
		Optional<Privacy> privacy = privacyRepository.findById(postStatusDto.getPrivacyTypeId());

		Post post = new Post(user, locations.get(), privacy.get(), postStatusDto.getStatus());
		
		return postStatusRepository.save(post);
		
	}

}
