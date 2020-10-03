package com.yusuf.travel.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yusuf.travel.model.Locations;
import com.yusuf.travel.model.User;
import com.yusuf.travel.repository.LocationsRepository;
import com.yusuf.travel.service.LocationService;
import com.yusuf.travel.service.PostService;
import com.yusuf.travel.web.dto.PostStatusDto;

@Controller
@RequestMapping("/poststatusform")
public class PostController {
	  
	@Autowired
	LocationsRepository locationRepo; 
	
	private PostService postService;
	
	public PostController(PostService postService) { 
		this.postService = postService;
	}
	
	@ModelAttribute("locationList") 
	public List<Locations> locaitonList() { 
		  List<Locations> loclist = locationRepo.findAll();
		return loclist; 
	}
	
	@ModelAttribute("post") 
	public PostStatusDto postStatusDto() { 
		  PostStatusDto psd = new PostStatusDto(); 
		  return psd; 
	}
	
	
	@GetMapping
	public String showStatusForm() { 
		  return "statusform"; 
	}
	  
	@PostMapping 
	public String postUserStatus(@ModelAttribute("post")
    PostStatusDto postStatusDto) { 
		postService.save(postStatusDto); 
		return "redirect:index"; 
    }
	 
}
