package com.springboot.demo.myspringapp.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.myspringapp.dao.StudentDao;
import com.springboot.demo.myspringapp.entity.Student;

import jakarta.persistence.EntityManager;


@Repository
public class StudentDaoImp implements StudentDao{

	private EntityManager entityManager;
	
	@Autowired
	public StudentDaoImp (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

}
