package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;

import jakarta.annotation.PostConstruct;

@RestController
public class UserProfileController {
	
	private Map<String, UserProfile> userMap;
	
	@PostConstruct
	public void init() {
		userMap = new HashMap<String, UserProfile>();
		userMap.put("1", new UserProfile("1","홍길동","111-1111","서울시 강서"));
		userMap.put("2", new UserProfile("2","가길동","112-1111","서울시 강동"));
		userMap.put("3", new UserProfile("3","나길동","113-1111","서울시 강복"));
	}
	

	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return userMap.get(id);
		
	}
	
}
