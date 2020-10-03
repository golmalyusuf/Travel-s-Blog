package com.yusuf.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yusuf.travel.model.Post;

public interface PostStatusRepository extends JpaRepository<Post, Long> {
	
}
