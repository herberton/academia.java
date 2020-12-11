
package com.example.defaults;

/**
 *
 * @author nristucc
 */
public class D implements B, C{
    //Implement m() here
    
    @Override
    public void m(){
        System.out.println(D.class.getSimpleName());
    }
    
}
