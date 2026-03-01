package com.coforge.Day5maven;

public class Customer  {

    private int custid;
    private String name;
    private String city;
    private double ordercost;

    // Default Constructor
    public Customer() {
    }

    // Parameterized Constructor
    public Customer(int custid, String name, String city, double ordercost) {
        this.custid = custid;
        this.name = name;
        this.city = city;
        this.ordercost = ordercost;
    }

    // Getters and Setters
    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getOrdercost() {
        return ordercost;
    }

    public void setOrdercost(double ordercost) {
        this.ordercost = ordercost;
    }

    // compareTo() for sorting by ordercost (Ascending)
//    @Override
//    public int compareTo(Customer o) {
//        return Double.compare(this.ordercost, o.ordercost);
//    }

//    @Override
//    public int compareTo(Customer o) {
//        return this.getName().compareTo(o.getName());
//    }
//    @Override
//    public int compareTo(Customer o) {
//        return this.getCity().compareTo(o.getCity());
//    }
    
    
    
    
    
    
    
    @Override
    public String toString() {
        return "Customer [ID=" + custid + 
               ", Name=" + name + 
               ", City=" + city + 
               ", OrderCost=" + ordercost + "]";
    }
    

}