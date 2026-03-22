package com.coforge.repoistry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.entities.Student;

public interface StuddentRepoistry  extends JpaRepository<Student, Long>{

	

}
