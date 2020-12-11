package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PieChartDynamic extends Application implements FileChangeListener {

  //private FileWatcher fileWatcher;
  //private Thread dirWatcherThread;
  private ScriptEngineManager manager;
  private ScriptEngine engine;
  private Stage primaryStage;
  private Path script;
  private WatchFile watcher;

  @Override
  public void init() {
    // create a script engine manager
    manager = new ScriptEngineManager();
    // create a Nashorn script engine
    engine = manager.getEngineByName("nashorn");
    // evaluate the script
    initFileWatcher();
  }

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    applyConfigScript();
    primaryStage.show();
  }

  @Override
  public void stop() {
    watcher.cancel();
  }

  private void initFileWatcher() {
    try {
      script = Paths.get("PieChartExample.js").toRealPath(LinkOption.NOFOLLOW_LINKS);
      System.out.println("URI: " + script);
      watcher = new WatchFile(script);
      watcher.addFileChangeListener(this);
      watcher.start();
    } catch (IOException ex) {
      System.out.println("Unable to start WatchFile: " + ex);
    }
  }

  private void applyConfigScript() {

    try {
      engine.eval(new FileReader(script.toFile()));
    } catch (ScriptException | FileNotFoundException ex) {
      System.out.println("File Exception: " + ex);
    }

    Invocable inv = (Invocable) engine;
    try {
      inv.invokeFunction("init", primaryStage);
    } catch (NoSuchMethodException | ScriptException ex) {
      System.out.println("Script Exception: " + ex);
    }
  }

  // Callback methods invoked by WatchFile
  @Override
  public void fileModified(Path file) {
    if (file.equals(script)) {
      Platform.runLater(() -> {
        applyConfigScript();
      });
    }
  }

  @Override
  public void fileDeleted(Path file) {
    if (file.equals(script)) {
      stop();
      Platform.exit();
    }
  }

  /**
   * The main() method is ignored in correctly deployed JavaFX application.
   * main() serves only as fallback in case the application can not be launched
   * through deployment artifacts, e.g., in IDEs with limited FX support.
   * NetBeans ignores main().
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
