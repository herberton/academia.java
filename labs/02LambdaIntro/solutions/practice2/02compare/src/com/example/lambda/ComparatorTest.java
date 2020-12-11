package com.example.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ComparatorTest {
    
  public static void main(String[] args) {
   
    List<Person> personList = Person.createShortList();
  
    
    
    // Use Lambda instead Asc    
    System.out.println("=== Sorted Asc SurName ===");
    Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));

    for(Person p:personList){
      p.printName();
    }
    
    // Print Desc target typing
    System.out.println("=== Sorted Desc SurName ===");
    Collections.sort(personList, (p1,  p2) -> p2.getSurName().compareTo(p1.getSurName()));

    for(Person p:personList){
      p.printName();
    }
    
  }}
