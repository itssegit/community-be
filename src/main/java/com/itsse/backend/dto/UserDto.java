package com.itsse.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
	private String email;
	private String nickname;
	private String password;
	private String phoneNo;
	private String username;
	private String birthday;
	
	private String token;
	private Long id;
	
	public UserDto() {
		
	}
}