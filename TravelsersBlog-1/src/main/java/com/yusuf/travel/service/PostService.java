package com.yusuf.travel.service;

import com.yusuf.travel.model.Post;
import com.yusuf.travel.web.dto.PostStatusDto;


public interface PostService {
	Post save(PostStatusDto postStatusDto); 
}
