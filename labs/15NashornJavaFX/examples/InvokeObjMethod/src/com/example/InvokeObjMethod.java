package com.example;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class InvokeObjMethod {

  public static void main(String[] args) {
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("nashorn");
    try {
      engine.eval("var obj = new Object()");
      engine.eval("obj.sayHello = function (str) { return 'Hello ' + str }");
      Object obj = engine.get("obj");
      Invocable inv = (Invocable) engine;
      String result = (String)inv.invokeMethod(obj, "sayHello", "Tom");
      System.out.println("Result: " + result);
    } catch (NoSuchMethodException | ScriptException ex) {
      System.out.println("Exception: " + ex);
    }
  }
}
