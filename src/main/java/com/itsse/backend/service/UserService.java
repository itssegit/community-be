package com.itsse.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itsse.backend.dto.UserDto;
import com.itsse.backend.entity.UserEntity;
import com.itsse.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity registerUser(UserDto dto) {
		//
		UserEntity entity = new UserEntity(dto);
		UserEntity result = userRepository.save(entity);
		return result;
	}
	
}
