package com.springboot.demo.myspringapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.demo.myspringapp.dao.StudentDao;
import com.springboot.demo.myspringapp.entity.Student;

@SpringBootApplication(
		scanBasePackages = {"com.springboot.demo.myspringapp",
		"com.sprinboot.demo.myspringapp.config"})
public class MyspringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringappApplication.class, args);
	}
	
	//command line runner is executed automatically once all the beans are created ..
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner->{
			System.out.println("hello command line runner ...");
			saveStudent(studentDao);
		};
	}
	
	public void saveStudent(StudentDao studentDao) {
		Student student = new Student("ashish","koirala","ashish.koirala@gmail.com");
		studentDao.save(student);
		System.out.println("student saved with id = "+student.getId());
	}

}
