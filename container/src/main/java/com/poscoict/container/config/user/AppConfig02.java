package com.poscoict.container.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poscoict.container.user.User;

// 패키지를 저장하는 대신에 얘를 읽어라 
//
@Configuration
public class AppConfig02 {
	
	@Bean
	public User user() {
		return new User("둘리");
	}
}
