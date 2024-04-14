package com.springboot.demo.myspringapp.dao;

import java.util.List;

import com.springboot.demo.myspringapp.entity.Student;

public interface StudentDao {

	void save (Student student);
	
	Student findById(int id);
	
	void saveMultiple(List<Student> listStudent);
	
	void getResult();
	
	int updateRow();
}
