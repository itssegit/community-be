package com.itsse.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsse.backend.dto.ResponseDto;
import com.itsse.backend.dto.UserDto;
import com.itsse.backend.entity.UserEntity;
import com.itsse.backend.security.TokenProvider;
import com.itsse.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDto dto) {
	    //
	    /*
	     * 
	     
		UserEntity user = userService.registerUser(dto);
		return ResponseEntity.ok(user);
		*/
	    try {
	        UserEntity user = new UserEntity(dto, passwordEncoder);
	        UserEntity userResult = userService.registerUser(user);
	        return ResponseEntity.ok(user);
	    } catch(Exception e) {
	        // 예외시 bad 리스폰스 리턴
	        ResponseDto responseDto = ResponseDto.builder().error(e.getMessage()).build();
	        return ResponseEntity.badRequest().body(responseDto);
	    }
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticate(@RequestBody UserDto dto) {
	    //
	    UserEntity user = userService.getByCredentials(dto.getEmail(), dto.getPassword(), passwordEncoder);
	    
	    if(user != null) {
	        final String token = tokenProvider.create(user);
	        UserDto responseUserDto = UserDto.builder()
	                .email(user.getEmail())
	                .nickname(user.getNickname())
	                .id(user.getIds())
	                .token(token)
	                .build();
	        //
	        return ResponseEntity.ok().body(responseUserDto);
	    } else {
	        ResponseDto responseDto = ResponseDto.builder()
	                .error("Login Failed").build();
	        //
	        return ResponseEntity.badRequest().body(responseDto);
	    }
	}
}
