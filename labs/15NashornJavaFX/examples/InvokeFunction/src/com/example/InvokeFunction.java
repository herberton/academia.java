package com.example;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class InvokeFunction {

  public static void main(String[] args) {
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("nashorn");
    try {
      engine.eval("function sayHello(str) { print ('Hello ' + str) }");
      Invocable inv = (Invocable) engine;
      inv.invokeFunction("sayHello", "Tom");
    } catch (NoSuchMethodException | ScriptException ex) {
      System.out.println("Exception: " + ex);
    }
  }
}
