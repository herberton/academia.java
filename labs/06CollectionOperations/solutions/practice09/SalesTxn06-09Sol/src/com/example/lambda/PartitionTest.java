package com.example.lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author oracle
 */
public class PartitionTest {
    
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
        Map<Boolean, List<SalesTxn>> tMap;
        
        // Print out transactions paritioned at $400k
        System.out.println("=== Transactions Partition ===");
        tMap = tList.stream()
            .collect(
                Collectors.partitioningBy(
                    t -> t.getTransactionTotal() >= 400000));
        
        tMap.forEach((k,v) -> {
            System.out.println("\nT/F: " + k);
            v.forEach(SalesTxn::printSummary);
        });
        
        
        
    }
}
