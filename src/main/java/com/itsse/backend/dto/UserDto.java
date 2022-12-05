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
	private String id;
	private String role;
	private String password;
	private String name;
	
	public UserDto() {
		
	}
}