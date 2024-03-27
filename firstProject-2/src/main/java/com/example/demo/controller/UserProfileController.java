package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

import ch.qos.logback.core.util.SystemInfo;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserProfileController {
	
	private UserService userService;
	
	@Autowired
	public UserProfileController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> getUserProfile(@PathVariable("id") int id) {
		return ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8").body(userService.findIdByUser(id));
		
	}
	
	
	@GetMapping("/user")
	public ResponseEntity<List<UserDto>> getUserList(){
		List<UserDto> lis = userService.findUserAll();
		return ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8").body(userService.findUserAll());
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<String> setUser(@RequestBody UserDto dto, HttpServletRequest request) {
		int num = 0;
		if(dto.getRegionId() > 0) {
			num = userService.setUserById(dto);
		}
		else {
			num = userService.setUser(dto);
		}
		if(num == 1) {
			return ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8").body("추가성공");
		}
		return ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8").body("추가 실패");
	}
	
	@PutMapping("/user")
	public ResponseEntity<String> updateUser(@RequestBody UserDto dto, HttpServletRequest request) {
		int num = userService.updateUserById(dto);
		
		if(num == 1) {
			return ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8").body("수정 성공");
		}
		return ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8").body("수정 실패");
	}
	
	@DeleteMapping("/user/{regionId}")
	public ResponseEntity<String> deleteUser(@PathVariable("regionId") int regionId) {
		int num = userService.deleteUserById(regionId);
		
		if(num == 1) {
			return ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8").body("삭제 성공");
		}
		return ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8").body("삭제 실패");
	}

	
	
}
