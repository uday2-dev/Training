package com.coforge.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.coforge.entities.Student;

@Repository
public class StudentDao implements StudentDaoInterface{
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	@Override
	public List<Student> getAll() {
		
		String queryString = "select * from student";
//		List<Student> sList = new ArrayList<Student>();
		RowMapper<Student> rowMapper = (rs,rows)->{
			Student student = new Student();
			student.setSid(rs.getLong("sid"));
			student.setSname(rs.getString("sname"));
			student.setCourse(rs.getString("course"));
			student.setAddress(rs.getString("address"));
//			sList.add(student);
			return student;
			
		};
		
		return jdbcTemplate.query(queryString,rowMapper);
	
	}

	@Override
	public String save(Student student) {
	
		
		String queryStudent = "insert into student (sname,course,address)values(?,?,?)";
		jdbcTemplate.update(queryStudent,student.getSname(),student.getCourse(),student.getAddress());
		return "row inserted";
		
		
	}

	@Override
	public Student getById(long sid) {
		String queryString = "select * from student where sid=?";
		RowMapper<Student>rowMapper = (rs,rows)->{
			Student student = new Student();
			student.setSid(rs.getLong("sid"));
			student.setSname(rs.getString("sname"));
			student.setCourse(rs.getString("course"));
			student.setAddress(rs.getString("address"));
			return student;
			
		};
		
		
		
		return jdbcTemplate.queryForObject(queryString, rowMapper, sid);
	}
	

}