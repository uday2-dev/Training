package com.coforge.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Order {
	@Value("2345")
	private int orderid;
	public Order() {
		super();
	}

	public Order(int orderid, int nou, double ordercost, Book book2) {
		super();
		this.orderid = orderid;
		this.nou = nou;
		this.ordercost = ordercost;
		this.book = book2;
	}

	@Value("5")
	private int nou;
	@Value("4000")
	private double ordercost;
	@Autowired
	private Book book;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getNou() {
		return nou;
	}

	public void setNou(int nou) {
		this.nou = nou;
	}

	public double getOrdercost() {
		return ordercost;
	}

	public void setOrdercost(double ordercost) {
		this.ordercost = ordercost;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", nou=" + nou + ", ordercost=" + ordercost + ", book=" + book + "]";
	}
}