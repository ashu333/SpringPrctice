package com.springboot.demo.myspringapp;

import java.util.ArrayList;
import java.util.List;

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
			//saveStudent(studentDao);
			//saveMultipleStudent(studentDao);
			System.out.println(studentDao.findById(2));
			studentDao.getResult();
			studentDao.updateRow();
		};
	}
	
	public void saveStudent(StudentDao studentDao) {
		Student student = new Student("ashish","koirala","ashish.koirala@gmail.com");
		studentDao.save(student);
		System.out.println("student saved with id = "+student.getId());
	}
	
	public void saveMultipleStudent(StudentDao studentDao) {
		Student student = new Student("ashish1","koirala1","ashish.koirala1@gmail.com");
		Student student1 = new Student("ashish2","koirala2","ashish.koirala2@gmail.com");
		Student student2= new Student("ashish3","koirala3","ashish.koirala3@gmail.com");
		List<Student> theStudentList = new ArrayList<Student>();
		theStudentList.add(student);
		theStudentList.add(student1);
		theStudentList.add(student2);
		studentDao.saveMultiple(theStudentList);
		//System.out.println("student saved with id = "+student.getId());
	}

}
