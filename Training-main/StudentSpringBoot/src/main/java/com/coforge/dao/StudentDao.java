package com.coforge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.entities.Student;
import com.coforge.repoistry.StuddentRepoistry;

public class StudentDao implements StudentDaoInterface {

	@Autowired
	private StuddentRepoistry studdentRepoistry;
	
	@Override
	public List<Student> getAllStudents() {
		return studdentRepoistry.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studdentRepoistry.save(student);
	}

	@Override
	public Student updateStudent(Student student, String name, String email, String mobile) {
		
		return studdentRepoistry.save(student);
	}

	@Override
	public Optional<Student> getStudentById(long id) {
		
	return studdentRepoistry.findById(id);
	}

	@Override
	public void deleteStudent(long id) {
	 studdentRepoistry.deleteById(id);
		
		
	}

}
