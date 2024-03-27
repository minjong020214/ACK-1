package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.UserDto;

@Service
public class UserService {
	
	private UserMapper userMapper;
	
	@Autowired
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public List<UserDto> findUserAll() {
		List<UserDto> lis = userMapper.findUserAll();
		return lis;
	}
	
	public UserDto findIdByUser(int id) {
		return userMapper.findIdByUser(id);
	}
	
	public int setUser(UserDto dto) {
		return userMapper.setUser(dto);
	}
	
	public int setUserById(UserDto dto) {
		return userMapper.setUserById(dto);
	}
	public int updateUserById(UserDto dto) {
		return userMapper.updateUserById(dto);
	}
	public int deleteUserById(int regionId) {
		return userMapper.deleteUserById(regionId);
	}
	
	
}
