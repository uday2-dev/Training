package com.coforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.entities.Student;
import com.coforge.service.StudentService;

@RestController
public class StudentContoller {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/student")   // requestmapping + get method
	public List<Student> getAllCustomer()
	{
		return service.getAllStudents();
	}
	@PostMapping("/student")
//	 combination of request mapping and method post
	public Student saveStudent(@RequestBody Student student)
	{
		return service.saveStudent(student);
	}
	@GetMapping("/student/{studentid}")
	public Student getStudentById(@PathVariable("studentid") long studentid)
	{
		return service.getStudentById(studentid);
	}
	@PutMapping("/student/{studentid}")
	public Student updateCustomer(@RequestBody Student student,@PathVariable("studentid") String name,String email,String mobile)
	{
		return service.updateStudent(student,name,email,mobile);
		
	}
	@DeleteMapping("/student/{studentid}")
	public void deleteCustomer(@PathVariable("studentid") long studentid)
	{
		service.deleteStudent(studentid);
	}

}
