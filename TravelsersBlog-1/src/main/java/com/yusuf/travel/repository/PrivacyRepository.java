package com.yusuf.travel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yusuf.travel.model.Privacy;

public interface PrivacyRepository extends JpaRepository<Privacy, Long>{
	Optional<Privacy> findById(Long id);
}
