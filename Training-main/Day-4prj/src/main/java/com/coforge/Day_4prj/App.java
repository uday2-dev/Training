package com.coforge.Day_4prj;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
      myinterface mi = new Democlass();
      mi.display();
      mi.printdetails();
      mi = new Hello();
      mi.display();
      myinterface.useparking("coforge");
      
    }
}
