package com.coforge.beans;

//import java.lang.foreign.AddressLayout;

public class Customer {
	private String cname;
	private long cid;
	private Address address;
	private String mobile;
	private String email;
	public Customer(String cname, long cid, Address address, String mobile, String email) {
		super();
		this.cname = cname;
		this.cid = cid;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", cid=" + cid + ", address=" + address + ", mobile=" + mobile + ", email="
				+ email + "]";
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
