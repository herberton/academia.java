#!/usr/bin/jjs 
# 
var exts = `ls`.trim().split("\n");

exts.forEach(function(file) {
    if (file.endsWith(".js")) {
        print(file);
    }
});
