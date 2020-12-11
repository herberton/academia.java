package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

  public static void main(String[] args) {
    try (Socket s = new Socket("localhost", 5432);
            InputStream is = s.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader stdIn
            = new BufferedReader(new InputStreamReader(System.in));) {

      String fromServer;
      String fromUser;

      while ((fromServer = in.readLine()) != null) {
        System.out.println("Server: " + fromServer);
        if (fromServer.equals("Bye.")) {
          break;
        }

        fromUser = stdIn.readLine();
        if (fromUser != null) {
          System.out.println("Client: " + fromUser);
          out.println(fromUser);
        }
      }
    } catch (IOException ex) {
      System.out.println("Exception: " + ex);
    }
  }
}
