package com.example.lambda;

import java.util.List;

/**
 * @author Oracle
 * Replace all anonymous inner classes with lambdas
 */
public class RoboMailTest01 {
  
  public static void main(String[] args) {
    
    List<Employee> pl = Employee.createShortList();
    RoboMail01 robo = new RoboMail01();
    
    System.out.println("\n==== RoboMail 01");
    System.out.println("\n=== Members of HR ===");
    robo.mail(pl, e -> e.getDept().equals("HR"));
    
    System.out.println("\n=== All Sales ===");
    robo.text(pl, e -> e.getDept().equals("Sales"));
    
    System.out.println("\n=== All Sales Execs");
    robo.text(pl, 
      e -> e.getRole().equals(Role.EXECUTIVE) 
        && e.getDept().equals("Sales"));
    
    System.out.println("\n=== All Sales 50+");
    robo.mail(pl, 
      e -> e.getAge() >= 50 
        && e.getDept().equals("Sales"));
  }
}
