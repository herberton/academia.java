package com.example.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author oracle
 */
public class P01Compute {
    
    public static void main(String[] args) {
        
        Map<String, String> cMap = new HashMap<>();
        
        cMap.put("UK", "London");
        cMap.put("US", "Washington");
        cMap.put("IT", "Rome");
        cMap.put("CA", "Ottawa");
        cMap.put("CZ", "Prague");
        cMap.put("JP", "Tokyo");
        
        cMap.computeIfPresent("IT", (k,v) -> v + " (Verified in " + k + ")");
        
        System.out.println("=== Map Contents ===");
        cMap.forEach((k,v) -> 
            System.out.println("Key: " + k + "  Value: " + v));
        
    }
}
