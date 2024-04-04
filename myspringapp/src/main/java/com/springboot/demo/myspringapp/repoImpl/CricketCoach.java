package com.springboot.demo.myspringapp.repoImpl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.springboot.learning.myspringapp.repository.Coach;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

	@Override
	public String practice() {
		return "Practice cricket 40 min...";
	}

}
