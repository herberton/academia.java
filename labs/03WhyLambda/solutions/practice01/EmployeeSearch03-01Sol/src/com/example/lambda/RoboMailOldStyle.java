package com.example.lambda;

import java.util.List;

/**
 *
 * @author MikeW
 * 
 * This is a basic class with a lot of redundancy.
 */
public class RoboMailOldStyle {
  
  public void mailAllHr(List<Employee> pl){
    for(Employee p:pl){
      if (p.getDept().equals("HR")){
        roboMail(p);
      }
    }
  }
  
  public void mailAllSales(List<Employee> pl){
    for(Employee p:pl){
      if (p.getDept().equals("Sales")){
        roboMail(p);
      }
    }
  }
  
  public void mailSalesExecutives(List<Employee> pl){
    for(Employee p:pl){
      if (p.getRole().equals(Role.EXECUTIVE) && p.getDept().equals("Sales")){
        roboMail(p);
      }
    }
  }
  
  public void maiSalesEmployeesOver50(List<Employee> pl){
    for(Employee p:pl){
      if (p.getAge() >= 50 && p.getDept().equals("Sales")){
        roboMail(p);
      }
    }
  }
  
  
  public void roboMail(Employee p){
    System.out.println("Emailing: " + p.getGivenName() 
      + " " + p.getSurName() + " age " + p.getAge() 
      + " at " + p.getEmail());
  }
  
  public void roboText(Employee p) {
    System.out.println("Texting: " + p.getGivenName()
      + " " + p.getSurName() + " age " + p.getAge()
      + " at " + p.getPhone());
  }
 
 
}
