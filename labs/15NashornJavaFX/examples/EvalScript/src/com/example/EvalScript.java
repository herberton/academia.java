package com.example;

import java.io.FileReader;
import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvalScript {

  public static void main(String[] args) throws Exception {
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("nashorn");
    try (FileReader f = new FileReader(args[0])) {
      engine.eval(f);
    } catch (IOException | ScriptException ex) {
      System.out.println("Exception: " + ex);
    }
  }
}