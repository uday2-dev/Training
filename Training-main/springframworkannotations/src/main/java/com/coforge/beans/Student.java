package com.coforge.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

public class Student {
	@Value("12345")
	private long sid;
	@Value("derrick")
	private String name;
	@Value("Computer Science")
	private String course;
	
	
}
