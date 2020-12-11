package com.example.lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author oracle
 */
public class P02Merge {
  public static void main(String[] args) {
        
    Map<String, String> cMap = new HashMap<>();
    String message = " (Verified C Country)";
        
    cMap.put("UK", "London");
    cMap.put("US", "Washington");
    cMap.put("IT", "Rome");
    cMap.put("CA", "Ottawa");
    cMap.put("CZ", "Prague");
    cMap.put("JP", "Tokyo");
        
    List<String> cList = cMap.keySet().stream()
        .filter(s -> s.startsWith("C"))
        .collect(Collectors.toList());

    cList.stream().forEach((e) -> {
        cMap.merge(e, message, (s,m) -> s.concat(m));
    });

    System.out.println("=== Map Contents ===");
    cMap.forEach((k,v) -> 
        System.out.println("Key: " + k + "  Value: " + v));
        
    }
}
