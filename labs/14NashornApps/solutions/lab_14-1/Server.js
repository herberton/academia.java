#!/usr/bin/jjs
// Simple threaded socket server

var ServerSocket = Java.type("java.net.ServerSocket");
var PrintWriter = Java.type("java.io.PrintWriter");
var OutputStreamWriter = Java.type("java.io.OutputStreamWriter");
var InputStreamReader = Java.type("java.io.InputStreamReader");
var BufferedReader = Java.type("java.io.BufferedReader");
var Thread = Java.type("java.lang.Thread");
var HandlerThread = Java.extend(Thread);
var socket;

// Create a server socket
try {
    var server = new ServerSocket(5432);
    while (true) {
        // Blocking call
        print("Server waiting for connections on port 5432");
        socket = server.accept();
        // Create the thread code
        var handler = new HandlerThread() {
            run: function() {
                print("Handling connection...");
                var out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                var inp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                var str = "Hello";
                while (str !== "Bye") {
                    out["println(String)"](str);
                    str = inp.readLine();
                }
                print("closing connection");
                out.close();
            }
        };
        // Start a new thread to handle communications
        handler.start();
    }
} catch (ex) {
    print(ex);
}