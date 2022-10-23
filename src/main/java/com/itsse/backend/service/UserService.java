package com.itsse.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itsse.backend.dto.UserDto;
import com.itsse.backend.entity.UserEntity;
import com.itsse.backend.repository.UserRepository;

@Service
@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity registerUser(UserEntity entity) {
		//
		UserEntity result = userRepository.save(entity);
		return result;
	}
	
	public UserEntity getByCredentials(final String email, final String password, final PasswordEncoder encoder) {
	    //
	    final UserEntity originalUser = userRepository.findByEmail(email);
	    
	    // matched 메서드를 이용하여 패스워드가 같은지 확인.
	    if(originalUser != null && encoder.matches(password, originalUser.getPassword())) {
	        return originalUser;
	    }
	    return null;
	}
	
}
