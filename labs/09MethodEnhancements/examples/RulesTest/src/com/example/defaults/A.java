
package com.example.defaults;

public interface A {
    default void m(){
        System.out.println(A.class.getSimpleName());
    }
}
