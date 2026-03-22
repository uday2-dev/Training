package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.dao.StudentDao;
import com.coforge.dao.StudentDaoInterface;
import com.coforge.entities.Student;

@Service
public class StudentService implements StudentServiceInterface{
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Student saveStudent(Student student) {
	
		return studentDao.saveStudent(student);
		
	}

	@Override
	public Student updateStudent(Student student, String name, String email, String mobile) {
		
		return studentDao.updateStudent(student, name, email, mobile);
	}

	@Override
	public Student getStudentById(long id) {
		// DAO returns Optional<Student>; unwrap safely
		return studentDao.getStudentById(id).orElse(null);
	}

	@Override
	public void deleteStudent(long id) {
		// use the autowired DAO to delete by id
		studentDao.deleteStudent(id);
		
		
	}
	
	
	
}