package com.coforge.dao;

import java.util.List;
import java.util.Optional;

import com.coforge.entities.Student;

public interface StudentDaoInterface {
	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student updateStudent(Student student, String name, String email, String mobile);
	public Optional<Student> getStudentById(long id);
	public void deleteStudent(long id);
	
}
