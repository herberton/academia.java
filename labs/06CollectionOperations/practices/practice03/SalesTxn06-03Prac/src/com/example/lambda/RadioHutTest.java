package com.example.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 * @author oracle
 */
public class RadioHutTest {
    
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
        Consumer<SalesTxn> radioReport = 
          t -> System.out.printf("ID: " + t.getTxnId() + "  Seller: " + t.getSalesPerson() 
          + "-- Buyer: " + t.getBuyerName() + " -- State: " 
          + t.getState() + " -- Amt: $%,9.0f%n", t.getTransactionTotal());
        
        // Print out Radio Hut Transactions
        System.out.println("=== Radio Hut Transactions ===");
        long count = 
            tList.stream()
                .filter(t -> t.getBuyer().getName().equals("Radio Hut"))
                    .sorted(Comparator.comparing(SalesTxn::getTransactionTotal).reversed())
                        .peek(radioReport)
                            .count();
        
        
        // Print out the total number of transactions
        System.out.print("Total Transactions: ");
        System.out.println(count);
        
        
        // Print largest transaction
        System.out.println("=== Radio Hut Largest ===");
        Optional<SalesTxn> max =
            tList.stream()
                .filter(t -> t.getBuyer().getName().equals("Radio Hut"))
                    .max(Comparator.comparing(SalesTxn::getTransactionTotal));
        
        if(max.isPresent()) {
            radioReport.accept(max.get());
        } else { 
            System.out.println("Valor máximo não encontrado");
        }
                
        // Print smallest transaction
        System.out.println("=== Radio Hut Smallest ===");
        Optional<SalesTxn> min =
            tList.stream()
                .filter(t -> t.getBuyer().getName().equals("Radio Hut"))
                    .min(Comparator.comparing(SalesTxn::getTransactionTotal));
        
        if(min.isPresent()) {
            radioReport.accept(min.get());
        } else { 
            System.out.println("Valor mínimo não encontrado");
        }
        
        
        
        
    }
}
