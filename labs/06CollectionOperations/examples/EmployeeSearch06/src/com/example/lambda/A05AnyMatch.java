package com.example.lambda;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author oracle
 */
public class A05AnyMatch {
    
    public static void main(String[] args) {
        
      List<Employee> eList = Employee.createShortList();
        
      System.out.println("\n== First CO Bonus ==");
      Optional<Employee> result;

      if (eList.stream().anyMatch(
          e -> e.getState().equals("CO"))){
            
        result = eList.stream()
          .peek(e -> System.out.println("Stream"))
          .filter(e -> e.getRole().equals(Role.EXECUTIVE))
          .filter(e -> e.getState().equals("CO"))
          .findFirst();

        if (result.isPresent()){result.get().printSummary();}
      }
        
        System.out.println("\n== Any CA Bonus ==");
        if (eList.stream().anyMatch(e -> e.getState().equals("CA"))){
            result = eList.stream()
                .peek(e -> System.out.println("Stream"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .findFirst();

        
            if (result.isPresent()){
                result.get().print();
            }
        }
        
    }
    
}
