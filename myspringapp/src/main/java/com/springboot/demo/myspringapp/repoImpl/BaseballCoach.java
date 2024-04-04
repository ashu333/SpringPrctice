package com.springboot.demo.myspringapp.repoImpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.springboot.learning.myspringapp.repository.Coach;

@Component
@Primary
public class BaseballCoach implements Coach {

	@Override
	public String practice() {
		return "practice baseball";
	}

}
