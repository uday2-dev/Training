package com.coforge.beans;

import java.util.HashSet;

public class Employee {
	private int eid;
	private String ename;
	private Department dept;
	
	private HashSet<String> skillSet;
	
	
	
	public HashSet<String> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(HashSet<String> skillSet) {
		this.skillSet = skillSet;
	}
	public Employee(int eid, String ename, Department dept, HashSet<String> skillSet) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.dept = dept;
		this.skillSet = skillSet;
	}
	public Employee(int eid, String ename, Department dept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.dept = dept;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", dept=" + dept + ", skillSet=" + skillSet + "]";
	}
	

}
