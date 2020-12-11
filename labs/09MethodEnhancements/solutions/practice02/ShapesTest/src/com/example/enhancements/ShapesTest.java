package com.example.enhancements;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class ShapesTest {
    public static final double target = 30;
    private static final DecimalFormat myFormatter = new DecimalFormat("#.###");
    
    public static void main(String[] args) {
        //Shape.printType();
        //Circle.printType();
        //Triangle.printType();
        //Sphere.printType();
        //Cone.printType();
        
        List<Shape> shapeList = new ArrayList<>();
        for(int i=1; i<=5; i++){
            shapeList.add(new Sphere(i));
            shapeList.add(new Cone(i));
        }
        
        shapeList.stream()
                .sorted((s1,s2) -> Double.compare(Shape.compareArea(target, s1), Shape.compareArea(target, s2)))
                .forEach(s -> System.out.println("Type: " +s.getClass().getSimpleName() +"\t length: " +s.getLength() +"\t diff: " +myFormatter.format(Shape.compareArea(target, s)) +"\t area: " +myFormatter.format(s.calcArea())));
        
    }    
}
