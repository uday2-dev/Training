package com.coforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.entities.Student;
import com.coforge.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired  
	private StudentService service;
	
	@RequestMapping("/list")
	public ModelAndView getAll()
	{
		List<Student> sList = service.getAll();
		ModelAndView mView = new ModelAndView("list");
		mView.addObject("sList",sList);
		return mView;
		
	}
	@RequestMapping("/add")
	public ModelAndView addStudent()
	{
		return new ModelAndView("add");
	}
	@RequestMapping( method = RequestMethod.POST)
	public String save(@ModelAttribute Student student)
	{
		System.out.println(student.getSname());
		System.out.println(student.getCourse());
		System.out.println(student.getAddress());
		 service.save(student);
		return "redirect:/student/list";
		
	}
		
		
		
}