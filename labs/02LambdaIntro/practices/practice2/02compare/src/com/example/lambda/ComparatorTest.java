package com.example.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {

        List<Person> personList = Person.createShortList();

        // Use Lambda instead Asc    
        System.out.println("=== Sorted Asc SurName ===");
        Collections
            .sort(
                personList,
                (p1, p2) -> {
                    
                    String p1Surname = p1.getSurName();
                    String p2Surname = p2.getSurName();
                    
                    return p1Surname.compareTo(p2Surname);
                }
            );
        for (Person p : personList) {
            p.printName();
        }

        // Print Desc target typing
        System.out.println("=== Sorted Desc SurName ===");
        
        // Use Lambda instead Desc
        Collections
            .sort(
                personList,
                (p1, p2) -> {
                    
                    String p1Surname = p1.getSurName();
                    String p2Surname = p2.getSurName();
                    
                    return p2Surname.compareTo(p1Surname);
                }
            );
        
        for (Person p : personList) {
            p.printName();
        }

    }
}
