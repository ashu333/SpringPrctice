package com.springboot.demo.myspringapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	String coachName;
	
	@Value("${team.name}")
	String teamName;
	
	@GetMapping("/")
	public String helloWord() {
		return "hello world from ashish..";
	}
	
	@GetMapping("/getTeamInfo")
	public String getTeamInfo() {
		return "team name is "+teamName +" ,coach name is "+coachName;
	}
}
