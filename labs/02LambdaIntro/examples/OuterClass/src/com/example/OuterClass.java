package com.example;

public class OuterClass {
    private String message = "Hi there";
    
    public class InnerClass {
        public void print(){
            System.out.println("Message from inner: " + message);
        }
    }
    
    public void print(){
        System.out.println("Message from outer: " + message);
        InnerClass ic = new InnerClass();
        ic.print();
    }
    
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        oc.print();
       
    }
    
}
