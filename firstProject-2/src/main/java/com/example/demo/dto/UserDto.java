package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Alias("UserDto")
public class UserDto {
	
	private int regionId;
	private String regionName;
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public UserDto(int regionId, String regionName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
	}
	

}
