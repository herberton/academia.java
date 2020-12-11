
package com.example.enhancements;

public class Sphere implements Circle{
    private double length;
    
    public Sphere(double length){
        this.length = length;
    }
    
    
    static void printType(){
        System.out.println(Sphere.class.getSimpleName());
    }
    
}
