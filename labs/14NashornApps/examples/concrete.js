var Thread = Java.type("java.lang.Thread");
var myThread = Java.extend(Thread);
var running = true;
var t = new myThread() {
    run: function() {
        while (running) {
            print("Thread running...");
            Thread.sleep(1000);
        }
    }
};

t.start();