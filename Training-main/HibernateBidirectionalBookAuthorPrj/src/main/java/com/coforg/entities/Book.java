package com.coforg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bookid")
	private long bookid;
	private String title;
	private double cost;
	
	@ManyToOne
	@JoinColumn(name = "authorid")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Author author;
	public Book(String title, double cost) {
		super();
		this.title = title;
		this.cost = cost;
		
	}
	public long getAuthorById(long bid) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}