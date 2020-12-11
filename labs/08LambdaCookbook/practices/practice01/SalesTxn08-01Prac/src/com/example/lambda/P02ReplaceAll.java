package com.example.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author oracle
 */
public class P02ReplaceAll {
    
    public static void main(String[] args) {
        ArrayList<SalesTxn> tList = (ArrayList) SalesTxn.createTxnList();
        Consumer<SalesTxn> shortSummary = s -> 
          System.out.println("ID: " + s.getTxnId() + " - " 
            + "Buyer: " + s.getBuyerName() + " - " + "Prod: " 
            + s.getProduct() + " - " + "ST: " + s.getState() + " - " 
            + "Amt: " + s.getTransactionTotal());
        
        System.out.println("===Starting List===");
        tList.forEach(shortSummary);
        
        // Replace all elements here
                 
        System.out.println("\n===Ending List===");
        tList.forEach(shortSummary);
    }
}
