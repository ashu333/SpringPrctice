package com.springboot.demo.myspringapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.myspringapp.repoImpl.CricketCoach;
import com.springboot.learning.myspringapp.repository.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	String coachName;
	
	@Value("${team.name}")
	String teamName;
	
	//field injection directle we inject even private fields but its not recomended..
	/*
	 * @Autowired private Coach cricketCoach;
	 */
	
	private Coach theCoach;
	
	private Coach theAnotherCoach;
	
	private Coach configuredCoach;
	
	//constructor injection 
	/*
	 * @Autowired public FunRestController(CricketCoach cricketCoach) {
	 * this.cricketCoach = cricketCoach; }
	 */
	
	//setter injection
	@Autowired
	public void settingTheCoachVariable(@Qualifier("cricketCoach") Coach theCoach ,
			@Qualifier("cricketCoach") Coach theAnotherCoach, 
			@Qualifier("tennisCoach") Coach configuredCoach) {
		this.theCoach = theCoach;
		this.theAnotherCoach = theAnotherCoach;
		this.configuredCoach = configuredCoach;
	}
	
	@GetMapping("/")
	public String helloWord() {
		return "hello world from ashish..";
	}
	
	@GetMapping("/getTeamInfo")
	public String getTeamInfo() {
		return "team name is "+teamName +" ,coach name is "+coachName;
	}
	
	@GetMapping("/getPlayType")
	public String getPlayType() {
		return theCoach.practice() +"------ configured coach = "+ configuredCoach.practice();
	}
	
	@GetMapping("/checkScope")
	public String checkScopeType() {
		return "scope of the coach and another coach is = "+(theCoach == theAnotherCoach);
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("after constucting init method invok = "+getClass().getSimpleName());
	}
	
	@PreDestroy
	public void beforeDetsroyMethod() {
		System.out.println("before destructing calling method = "+getClass().getCanonicalName());
	}
}
