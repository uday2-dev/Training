package com.coforge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.dao.StudentDao;
import com.coforge.dao.StudentDaoInterface;
import com.coforge.entities.Student;

@Service
public class StudentService implements StudentServiceInterface{
	
	@Autowired
	private StudentDaoInterface studentdao;
	
	
	@Override
	public List<Student> getAll() {
		
		return studentdao.getAll();
	}

	@Override
	public String save(Student student) {
		
		return studentdao.save(student);
	}

	@Override
	public Student getById(long sid) {
	
		return studentdao.getById(sid);
	}

}
