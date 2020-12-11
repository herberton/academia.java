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
        
        tList.replaceAll(e ->
            new SalesTxn.Builder()
            .txnId(11)
            .salesPerson("Jane Doe")
            .buyer(Buyer.getBuyerMap().get("Acme"))
            .product("Widget")
            .paymentType("Cash")
            .unitPrice(20)
            .unitCount(3000)
            .txnDate(LocalDate.of(2013,1,25))
            .city("San Jose")
            .state(State.CA)
            .code("95101")
            .build()     
        );
                 
        System.out.println("\n===Ending List===");
        tList.forEach(shortSummary);
    }
}
