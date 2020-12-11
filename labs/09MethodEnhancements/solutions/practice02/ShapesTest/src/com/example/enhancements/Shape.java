
package com.example.enhancements;

public interface Shape {
    static void printType(){
        System.out.println(Shape.class.getSimpleName());
    }
          
    default double calcArea(){
        return 0;
    }
    
    static double compareArea(double target, Shape s){
        return Math.abs(target - s.calcArea());
    }
    
    abstract double getLength();
}
