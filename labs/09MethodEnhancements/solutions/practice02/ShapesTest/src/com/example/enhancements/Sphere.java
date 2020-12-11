
package com.example.enhancements;

public class Sphere implements Circle {
    private double length;
    
    public Sphere(double length){
        this.length = length;
    }
    
    
    static void printType(){
        System.out.println(Sphere.class.getSimpleName());
    }
    
    @Override
    public double getLength() {
        return length;
    }
    @Override
    public double calcArea(){
        return(4*Math.PI*getLength()*getLength());
    } 
}
