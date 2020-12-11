
package com.example.enhancements;

public interface Triangle extends Shape {
    
    static void printType(){
        System.out.println(Triangle.class.getSimpleName());
    }

}
