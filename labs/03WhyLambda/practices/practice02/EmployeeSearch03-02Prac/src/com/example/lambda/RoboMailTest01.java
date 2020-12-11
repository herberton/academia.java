package com.example.lambda;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Oracle
 * Reuse lambda expressions
 */
public class RoboMailTest01 {
  
  public static void main(String[] args) {
    
    List<Employee> pl = Employee.createShortList();
    RoboMail01 robo = new RoboMail01();

    Predicate<Employee> salesExecutives =
        e -> e.getDept().equals("Sales"); // Define lambda for this
    
    Predicate<Employee> salesEmployeesOver50 =
        e-> e.getAge() >= 50 && e.getDept().equals("Sales"); // Define Lambda for this
    
    System.out.println("\n==== RoboMail 01");
    System.out.println("\n=== Sales Execs ===");
    //robo.mail();  // Update with Lambda variable
    robo.mail(pl, salesExecutives);
    //robo.text(); // Update with Lambda variable
    robo.text(pl, salesExecutives);
    
    System.out.println("\n=== All Sales ===");
    //robo.mail(); // Update with Lambda variable
    robo.mail(pl, salesEmployeesOver50);
    //robo.text(); // Update with Lambda variable   
    robo.text(pl, salesEmployeesOver50);
  }
}
