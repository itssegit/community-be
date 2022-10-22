package com.itsse.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
	private String email;
	private String nickname;
	private String password;
	private String phoneNo;
	private String username;
	private String birthday;
	
	public UserDto() {
		
	}
}