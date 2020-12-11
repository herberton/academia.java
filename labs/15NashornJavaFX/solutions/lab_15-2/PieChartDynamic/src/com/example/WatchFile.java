package com.example;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

public class WatchFile extends Thread {

  private PieChartDynamic app;
  private final WatchService watcher;
  private final Map<WatchKey, Path> keys;
  private final Path directory;
  private final Path file;
  private volatile boolean running = true;
  private FileChangeListener listener = null;

  public WatchFile(Path dir) throws IOException {
    this.watcher = FileSystems.getDefault().newWatchService();
    this.keys = new HashMap<>();
    directory = dir.getParent();
    file = dir.getFileName();
    System.out.println("Registering: " + dir);
    register(directory);
  }

  private void register(Path dir) throws IOException {
    //WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    WatchKey key = dir.register(watcher, ENTRY_DELETE, ENTRY_MODIFY);
    keys.put(key, dir);
  }

  public void addFileChangeListener(FileChangeListener listener) {
    this.listener = listener;
  }

  // An example of a Generic method
  @SuppressWarnings("unchecked")
  static <T> WatchEvent<T> cast(WatchEvent<?> event) {
    return (WatchEvent<T>) event;
  }

  public void cancel() {
    running = false;
    this.interrupt();
  }

  @Override
  public void run() {

    while (running) {

      // wait for key to be signalled
      WatchKey key;
      try {
        key = watcher.take();
      } catch (InterruptedException x) {
        return;
      }

      Path dir = keys.get(key);
      if (dir == null) {
        System.err.println("WatchKey not recognized!!");
        continue;
      }

      for (WatchEvent<?> event : key.pollEvents()) {
        WatchEvent.Kind kind = event.kind();

        // Context for directory entry event is the file name of entry
        WatchEvent<Path> ev = cast(event);
        Path name = ev.context();
        Path child = dir.resolve(name);
        Path fileName = child.getFileName();

        // print out event
        System.out.format("%s: %s\n", event.kind().name(), child);

        switch (event.kind().name()) {
          case "ENTRY_MODIFY":
            listener.fileModified(child);
            break;
          case "ENTRY_DELETE":
            listener.fileDeleted(child);
            break;
          default:
            break;
        }

      }

      // reset key and remove from set if directory no longer accessible
      boolean valid = key.reset();
      if (!valid) {
        keys.remove(key);

        // all directories are inaccessible
        if (keys.isEmpty()) {
          break;
        }
      }
    }
  }
}
