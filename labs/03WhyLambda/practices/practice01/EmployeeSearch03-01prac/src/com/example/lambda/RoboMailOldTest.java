package com.example.lambda;

import java.util.List;

/**
 *
 * @author MikeW
 */
public class RoboMailOldTest {
  
  public static void main(String[] args) {
    
    List<Employee> pl = Employee.createShortList();
    RoboMailOldStyle robo = new RoboMailOldStyle();
    
    System.out.println("\n==== RoboMail Old Style Test");
    System.out.println("\n=== Members of HR");
    robo.mailAllHr(pl);
    
    System.out.println("\n=== All Sales");
    robo.mailAllSales(pl);
    
    System.out.println("\n=== All Sales Executives");
    robo.mailSalesExecutives(pl);
    
    System.out.println("\n=== All Sales Employees 50+");
    robo.maiSalesEmployeesOver50(pl);

  }

}
