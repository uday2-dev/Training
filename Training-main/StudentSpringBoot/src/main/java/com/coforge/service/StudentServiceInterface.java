package com.coforge.service;

import java.util.List;

import com.coforge.entities.Student;

public interface StudentServiceInterface {
	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student updateStudent(Student student, String name, String email, String mobile);
	public Student getStudentById(long id);
	public void deleteStudent(long id);

}
