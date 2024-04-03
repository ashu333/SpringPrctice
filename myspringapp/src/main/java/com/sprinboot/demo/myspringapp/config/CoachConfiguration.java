package com.sprinboot.demo.myspringapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.demo.myspringapp.repoImpl.TennisCoach;
import com.springboot.learning.myspringapp.repository.Coach;

@Configuration
public class CoachConfiguration {

	@Bean("tennisCoach")
	public Coach getTennisCoach() {
		return new TennisCoach();
	}
}
