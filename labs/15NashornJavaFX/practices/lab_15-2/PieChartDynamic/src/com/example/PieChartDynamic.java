package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PieChartDynamic extends Application {

    private FileWatcher fileWatcher;
    private Thread dirWatcherThread;
    private ScriptEngineManager manager;
    private ScriptEngine engine;
    private Stage primaryStage;
    private Path script;

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
        dirWatcherThread.interrupt();
    }

    private void initFileWatcher() {
        // Attach file fileWatcher
        if (null != dirWatcherThread && dirWatcherThread.isAlive()) {
            dirWatcherThread.interrupt();
        }
        script = Paths.get("PieChartExample.js");
        System.out.println("URI: " + script.toUri().toString());
        File fileToWatch = new File(script.toUri());
        fileWatcher = new FileWatcher(fileToWatch);
        fileWatcher.setOnFileModified(watcherEvent -> Platform.runLater(() -> applyConfigScript()));
        fileWatcher.setOnFileRemoved(watcherEvent -> dirWatcherThread.interrupt());
        dirWatcherThread = new Thread(fileWatcher);
        dirWatcherThread.start();
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

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
