package com.example;

import java.nio.file.Path;

public interface FileChangeListener {
  public void fileModified(Path file);
  public void fileDeleted(Path file);
}
