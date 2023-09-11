package com.login.UserLogin;

import com.login.UserLogin.models.ERole;
import com.login.UserLogin.models.RoleEntity;
import com.login.UserLogin.models.UserEntity;
import com.login.UserLogin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class UserLoginApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserLoginApplication.class, args);
		System.out.println("App is running!");
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

//	@Bean
//	CommandLineRunner init(){
//		return args -> {
//
//			UserEntity userEntity = UserEntity.builder()
//					.email("habib@mail.com")
//					.username("habib")
//					.password(passwordEncoder.encode("1234"))
//					.roles(Set.of(RoleEntity.builder()
//							.name(ERole.valueOf(ERole.ADMIN.name()))
//							.build()))
//					.build();
//
//			UserEntity userEntity2 = UserEntity.builder()
//					.email("david@mail.com")
//					.username("david")
//					.password(passwordEncoder.encode("1234"))
//					.roles(Set.of(RoleEntity.builder()
//							.name(ERole.valueOf(ERole.USER.name()))
//							.build()))
//					.build();
//
//			UserEntity userEntity3 = UserEntity.builder()
//					.email("andrea@mail.com")
//					.username("andrea")
//					.password(passwordEncoder.encode("1234"))
//					.roles(Set.of(RoleEntity.builder()
//							.name(ERole.valueOf(ERole.GUEST.name()))
//							.build()))
//					.build();
//
//			userRepository.save(userEntity);
//			userRepository.save(userEntity2);
//			userRepository.save(userEntity3);
//		};
//	}

}
