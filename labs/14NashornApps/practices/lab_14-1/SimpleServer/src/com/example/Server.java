package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

  private final Socket clientSocket;

  public Server(Socket s) {
    clientSocket = s;
  }

  public static void main(String[] args) throws IOException {

    try {
      ServerSocket serverSocket = new ServerSocket(5432);
      while (true) {
        Socket clientSocket = serverSocket.accept();
        Server server = new Server(clientSocket);
        server.start();
      }

    } catch (IOException ex) {
      System.out.println("Exception creating server: " + ex);
      System.exit(-1);
    }

  }

  // Handle communication with the client
  @Override
  public void run() {
    try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in
            = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

      String outputLine = "hello";
      while (!outputLine.equals("Bye")) {
        out.println(outputLine);
        outputLine = in.readLine();
      }

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
