var r  = new java.lang.Runnable() {
    run: function() {
        print("running...\n");
    }
};

var th = new java.lang.Thread(r);
th.start();
