function r() {   
  print("Hey! I am a thread!");
};

var th = new java.lang.Thread(r);
th.start();