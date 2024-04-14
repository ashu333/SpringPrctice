package com.springboot.demo.myspringapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.demo.myspringapp.entity.Employee;

//by default it is /employees as the entity class now changing the path 

@RepositoryRestResource(path = "newEmploeePath")
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
