package com.coforge.entities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import com.mysql.cj.Session;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import org.hibernate.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Item {
	@Id
	private long id;
	private String name;
	private double cost;
	
	
	

}
