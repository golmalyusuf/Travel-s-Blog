package com.yusuf.travel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;


@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
 
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User userpost;
	
	@ManyToOne(targetEntity = Locations.class)
	@JoinColumn(name = "location_id", nullable = false)
	private Location locationPoint;
	
	@ManyToOne(targetEntity = Privacy.class)
	@JoinColumn(name = "privacy_id", nullable = false)
	private Privacy privacyType;
	
	public Post() {
	}

	public Post(long id, User userpost, Location locationPoint, Privacy privacyType, String status) {
		this.id = id;
		this.userpost = userpost;
		this.locationPoint = locationPoint;
		this.privacyType = privacyType;
		this.status = status;
	}


	@Column(name = "status", nullable = false)
	private String status;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public User getUser() {
		return userpost;
	}


	public void setUser(User userpost) {
		this.userpost = userpost;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public User getUserpost() {
		return userpost;
	}

	public void setUserpost(User userpost) {
		this.userpost = userpost;
	}

	public Location getLocationPoint() {
		return locationPoint;
	}

	public void setLocationPoint(Location locationPoint) {
		this.locationPoint = locationPoint;
	}

	public Privacy getPrivacyType() {
		return privacyType;
	}

	public void setPrivacyType(Privacy privacyType) {
		this.privacyType = privacyType;
	}
}
