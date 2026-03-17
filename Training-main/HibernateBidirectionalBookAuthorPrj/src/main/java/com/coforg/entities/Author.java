package com.coforg.entities;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long authorid;
	private String name;
	private String address;
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Book> booklist = new ArrayList<>();
	public Author(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.booklist = new ArrayList<>();
		
	}
	public void addBook(Book book)
	{
		booklist.add(book);
		book.setAuthor(this);
		
	}
	public void removeBook(Book book)
	{
		booklist.remove(book);
		book.setAuthor(null);
	}
	

}