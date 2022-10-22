package com.itsse.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.itsse.backend.dto.UserDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="TB_USER")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ids;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="nickname", nullable = false)
	private String nickname;
	
	@Column(name="about_me")
	private String aboutMe;
	
	@Column(name="username", nullable = false)
	private String username;
	
	@Column(name="birthday", nullable = false)
	private String birthday;
	
	@Column(name="phone_no", nullable = false)
	private String phoneNo;
	
	@Builder
	public UserEntity(UserDto dto) {
		this.email = dto.getEmail();
		this.nickname = dto.getNickname();
		this.username = dto.getUsername();
		this.birthday = dto.getBirthday();
		this.phoneNo = dto.getPhoneNo();
		this.password = dto.getPassword();
	}
	
}
