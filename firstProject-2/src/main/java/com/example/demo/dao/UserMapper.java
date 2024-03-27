package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDto;

@Mapper
public interface UserMapper {
	
	public List<UserDto> findUserAll();
	public UserDto findIdByUser(int id);
	public int setUser(UserDto dto);
	public int setUserById(UserDto dto);
	public int updateUserById(UserDto dto);
	public int deleteUserById(int regionId);
	
}
