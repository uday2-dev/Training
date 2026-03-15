package com.coforge.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="order_table")

public class Orders {
	@Id
	private int orderid;
	private LocalDate orderDate;
	private String customername;
	//private List<Item>itemlist;
	

}
