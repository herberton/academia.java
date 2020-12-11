package com.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PassJavaObj {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:\nPassJavaObj <file name> {<file name> ...}");
            System.exit(-1);
        }
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");
        // Put the file name to search for into a variable called file
        engine.put("filenames", args);
        try {
            // run the script to check if the file exists
            engine.eval(new FileReader("fileExists.js"));
        } catch (FileNotFoundException | ScriptException ex) {
            System.out.println("Exception" + ex);
        }
    }
    
}
