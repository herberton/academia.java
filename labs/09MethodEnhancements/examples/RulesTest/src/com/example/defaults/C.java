
package com.example.defaults;

public interface C extends A {
    @Override
    default void m(){
        System.out.println(C.class.getSimpleName());
    }
}
