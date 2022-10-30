package com.itsse.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itsse.backend.entity.UserEntity;
import com.itsse.backend.repository.UserRepository;

@Service
@Component
public class UserService {
    
    public static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity registerUser(UserEntity entity) {
		//
		UserEntity result = userRepository.save(entity);
		return result;
	}
	
	public UserEntity getByCredentials(final String email, final String password, final PasswordEncoder encoder) {
	    //
	    UserEntity originalUser = userRepository.findByEmail(email);                             ;
	    // matched 메서드를 이용하여 패스워드가 같은지 확인.
	    if(originalUser != null && encoder.matches(password, originalUser.getPassword())) {
	        return originalUser;
	    }
	    return null;
	}
	
}
