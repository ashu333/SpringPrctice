package com.springboot.demo.myspringapp.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.myspringapp.dao.StudentDao;
import com.springboot.demo.myspringapp.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDaoImp implements StudentDao {

	private EntityManager entityManager;

	@Autowired
	public StudentDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	@Transactional
	public void saveMultiple(List<Student> listStudent) {
		for (Student obj : listStudent) {
			entityManager.persist(obj);
		}
		//entityManager.persist(listStudent);
	}

	@Override
	public void getResult() {
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
		List<Student> theStudentList = theQuery.getResultList();
		System.out.println("printing all the students..");
		for (Student obj : theStudentList) {
			System.out.println(obj);
		}
		TypedQuery<Student> theQuery1 = entityManager.createQuery("from Student where firstName = :FirstName and lastName "
				+ " = :LastName and email like '%1%' ", Student.class);
		theQuery1.setParameter("FirstName", "ashish1");
		theQuery1.setParameter("LastName", "koirala1");
		
		List<Student> theListStudent =   theQuery1.getResultList();
		System.out.println("the query parameter ...result list ...");
		for(Student obj : theListStudent) {
			System.out.println(obj);
		}

	}

	@Override
	@Transactional
	public int updateRow() {
		Student firstUpdate  = findById(2);
		firstUpdate.setFirstName("Poulami");
		firstUpdate.setLastName("Mukherjee");
		firstUpdate.setEmail("New@email");
		entityManager.merge(firstUpdate);
		System.out.println("Single row updated");
		
		return entityManager.createQuery("Update Student set lastName = 'kumar' where firstName like '%2%'").executeUpdate();
	}
	
	

}
