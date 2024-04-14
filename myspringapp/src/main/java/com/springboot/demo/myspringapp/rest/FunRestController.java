package com.springboot.demo.myspringapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.myspringapp.customException.StudentException;
import com.springboot.demo.myspringapp.dao.EmployeeDao;
import com.springboot.demo.myspringapp.dao.StudentDao;
import com.springboot.demo.myspringapp.entity.Employee;
import com.springboot.demo.myspringapp.entity.Student;
import com.springboot.learning.myspringapp.repository.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
@RequestMapping("/mineApp")
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
	
	private StudentDao studentDao;
	
	//constructor injection 
	/*
	 * @Autowired public FunRestController(CricketCoach cricketCoach) {
	 * this.cricketCoach = cricketCoach; }
	 */
	
	//setter injection
	@Autowired
	public void settingTheCoachVariable(@Qualifier("cricketCoach") Coach theCoach ,
			@Qualifier("cricketCoach") Coach theAnotherCoach, 
			@Qualifier("tennisCoach") Coach configuredCoach,
			StudentDao studentDao) {
		this.theCoach = theCoach;
		this.theAnotherCoach = theAnotherCoach;
		this.configuredCoach = configuredCoach;
		this.studentDao = studentDao;
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
	
	@GetMapping("/getStudentList")
	public List<Student> getStudentList(){
		List<Student> theStudentList = new ArrayList<Student>();
		Student student1 = new Student("new student 1","title 1","email 1");
		Student student2 = new Student("new student 2","title 2","email 2");
		Student student3 = new Student("new student 3","title 3","email 3");
		theStudentList.add(student1);
		theStudentList.add(student2);
		theStudentList.add(student3);
		
		return theStudentList;
	}
	
	@GetMapping("/getStudentById/{studentId}")
	public Student getStudentById(@PathVariable int studentId) throws StudentException{
		
			Student response = studentDao.findById(studentId);
			System.out.println(response);
			if(response == null)
				throw new StudentException("id "+studentId +" Not found");
		return response;
		
			
		
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
