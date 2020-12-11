#!/usr/bin/jjs -scripting

var goodInput = false;
while (!goodInput) {
    var inp = readLine("Directories(d) or Files(f) ");
    if (inp == "d" || inp == "f") {
        goodInput = true;
    }
}
var results = $EXEC("ls -l").split("\n");
for (var i = 0; i < results.length - 1; i++) {
    if (results[i].startsWith("d")) {
        if (inp == "d") {
            print (results[i]);
        }
    } else {
        if (inp == "f") {
            print (results[i]);
        }
    }
}