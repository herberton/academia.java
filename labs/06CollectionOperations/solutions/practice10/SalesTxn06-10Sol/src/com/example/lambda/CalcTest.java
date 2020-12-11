package com.example.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author oracle
 */
public class CalcTest {
    
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
        
        // Option 1
        Map<String, Double> map = tList.stream()
            .filter(t -> "Radio Hut".equals(t.getBuyerName())
                  || "PriceCo".equals(t.getBuyerName())
                  || "Best Deals".equals(t.getBuyerName()))
            .collect(Collectors.groupingBy(SalesTxn::getBuyerName,
                Collectors.summingDouble(SalesTxn::getTransactionTotal)));
        
        System.out.println("=== Sales Report");
        map.forEach((k,v) -> 
          { System.out.printf(k + " Sales: $%,9.2f%n", v);});

        // Option 2
        Set<String> preferredBuyers = new HashSet<>();
          preferredBuyers.add("Radio Hut");
          preferredBuyers.add("PriceCo");
          preferredBuyers.add("Best Deals");

        System.out.println("=== Sales Report");
        Map<String, Double> map2 = tList.stream()
          .filter(t -> preferredBuyers.contains(t.getBuyerName()))
          .collect(Collectors.groupingBy(SalesTxn::getBuyerName,
              Collectors.summingDouble(SalesTxn::getTransactionTotal)));

        map2.forEach((k,v) -> 
          { System.out.printf(k + " Sales: $%,9.2f%n", v);});
        
        
    }
}
