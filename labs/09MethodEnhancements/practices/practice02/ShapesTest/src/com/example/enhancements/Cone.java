
package com.example.enhancements;

public class Cone implements Circle, Triangle{
    private double length;
    
    public Cone(double length){
        this.length = length;
    }
    
    
    static void printType(){
        System.out.println(Cone.class.getSimpleName());
    }
    
}
