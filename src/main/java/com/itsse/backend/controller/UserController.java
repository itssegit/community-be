package com.itsse.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsse.backend.dto.UserDto;
import com.itsse.backend.entity.UserEntity;
import com.itsse.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> registerUser(@RequestBody UserDto dto) {
		UserEntity user = userService.registerUser(dto);
		return ResponseEntity.ok(user);
	}
}
