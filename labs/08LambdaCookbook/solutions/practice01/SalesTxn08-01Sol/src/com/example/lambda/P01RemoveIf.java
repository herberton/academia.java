package com.example.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author oracle
 */
public class P01RemoveIf {
    public static void main(String[] args) {
        ArrayList<SalesTxn> tList = 
            (ArrayList) SalesTxn.createTxnList();
        Consumer<SalesTxn> shortSummary = s -> 
          System.out.println("ID: " + s.getTxnId() + " - " 
            + "Buyer: " + s.getBuyerName() + " - " + "Prod: " 
            + s.getProduct() + " - " + "ST: " + s.getState() + " - " 
            + "Amt: " + s.getTransactionTotal());
        
        System.out.println("===Starting List===");
        tList.forEach(shortSummary);
        
        tList.removeIf(e -> e.getBuyerName().equals("Radio Hut"));
        
        System.out.println("\n===Ending List===");
        tList.forEach(shortSummary);
    }
}
