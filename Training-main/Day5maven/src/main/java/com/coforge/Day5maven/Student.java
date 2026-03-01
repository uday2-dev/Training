package com.coforge.Day5maven;

public class Student implements Comparable<Student>{
	private String name;
	private int studentid;
	private int marks;
	public Student() {
		super();
	}
	public Student(String name, int studentid, int marks) {
		super();
		this.name = name;
		this.studentid = studentid;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", studentid=" + studentid + ", marks=" + marks + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public int compareTo(Student o) {
		return this.studentid-o.studentid;
		
	}
	
	

}
