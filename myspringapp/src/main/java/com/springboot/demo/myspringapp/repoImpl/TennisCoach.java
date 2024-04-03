package com.springboot.demo.myspringapp.repoImpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.springboot.learning.myspringapp.repository.Coach;


public class TennisCoach implements Coach{

	@Override
	public String practice() {
		return "Prcatice Tennis";
	}

}
