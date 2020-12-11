package com.example;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.EventHandler;
import javafx.event.EventType;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * Created by User: hansolo Date: 21.03.13 Time: 13:56
 */
public class FileWatcher implements Runnable {

    private final Path PATH;
    private final String FILE_NAME;

    // ******************** Constructors **************************************
    public FileWatcher(final File FILE_TO_WATCH) {
        PATH = FileSystems.getDefault().getPath(FILE_TO_WATCH.getParent());
        System.out.println("Path: " + PATH);
        FILE_NAME = FILE_TO_WATCH.getName();
        System.out.println("File: " + FILE_NAME);
    }

    // ******************** Event handling ************************************
    public final ObjectProperty<EventHandler<FileWatcherEvent>> onFileCreatedProperty() {
        return onFileCreated;
    }

    public final void setOnFileCreated(EventHandler<FileWatcherEvent> value) {
        onFileCreatedProperty().set(value);
    }

    public final EventHandler<FileWatcherEvent> getOnFileCreated() {
        return onFileCreatedProperty().get();
    }
    private ObjectProperty<EventHandler<FileWatcherEvent>> onFileCreated = new ObjectPropertyBase<EventHandler<FileWatcherEvent>>() {

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onFileModified";
        }
    };

    public final ObjectProperty<EventHandler<FileWatcherEvent>> onFileModifiedProperty() {
        return onFileModified;
    }

    public final void setOnFileModified(EventHandler<FileWatcherEvent> value) {
        onFileModifiedProperty().set(value);
    }

    public final EventHandler<FileWatcherEvent> getOnFileModified() {
        return onFileModifiedProperty().get();
    }
    private ObjectProperty<EventHandler<FileWatcherEvent>> onFileModified = new ObjectPropertyBase<EventHandler<FileWatcherEvent>>() {

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onFileModified";
        }
    };

    public final ObjectProperty<EventHandler<FileWatcherEvent>> onFileRemovedProperty() {
        return onFileRemoved;
    }

    public final void setOnFileRemoved(EventHandler<FileWatcherEvent> value) {
        onFileRemovedProperty().set(value);
    }

    public final EventHandler<FileWatcherEvent> getOnFileRemoved() {
        return onFileRemovedProperty().get();
    }
    private ObjectProperty<EventHandler<FileWatcherEvent>> onFileRemoved = new ObjectPropertyBase<EventHandler<FileWatcherEvent>>() {

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onFileRemoved";
        }
    };

    public void fireWatchEvent(final FileWatcherEvent EVENT) {
        System.out.println("Event");
        final EventType TYPE = EVENT.getEventType();
        final EventHandler<FileWatcherEvent> HANDLER;
        if (FileWatcherEvent.FILE_CREATED == TYPE) {
            HANDLER = getOnFileCreated();
        } else if (FileWatcherEvent.FILE_MODIFIED == TYPE) {
            HANDLER = getOnFileModified();
        } else if (FileWatcherEvent.FILE_REMOVED == TYPE) {
            HANDLER = getOnFileRemoved();
        } else {
            HANDLER = null;
        }

        if (HANDLER != null) {
            HANDLER.handle(EVENT);
        }
        EVENT.consume();
    }

    // ******************** Methods *******************************************
    private void handleEvent(WatchEvent event) {
        final java.nio.file.WatchEvent.Kind<?> KIND = event.kind();
        if (StandardWatchEventKinds.ENTRY_MODIFY.equals(KIND)) {
            if (FILE_NAME.equals(event.context().toString())) {
                fireWatchEvent(new FileWatcherEvent(this, null, FileWatcherEvent.FILE_MODIFIED));
            }
        } else if (StandardWatchEventKinds.ENTRY_CREATE.equals(KIND)) {
            if (FILE_NAME.equals(event.context().toString())) {
                fireWatchEvent(new FileWatcherEvent(this, null, FileWatcherEvent.FILE_CREATED));
            }
        } else if (StandardWatchEventKinds.ENTRY_DELETE.equals(KIND)) {
            if (FILE_NAME.equals(event.context().toString())) {
                fireWatchEvent(new FileWatcherEvent(this, null, FileWatcherEvent.FILE_REMOVED));
            }
        }
    }

    @Override
    public void run() {
        try {
            WatchService watchService = PATH.getFileSystem().newWatchService();
            PATH.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);

            // loop forever to watch directory
            while (true) {
                WatchKey watchKey;
                watchKey = watchService.take(); // this call is blocking until events are present

                // poll for file system events on the WatchKey
                for (final WatchEvent event : watchKey.pollEvents()) {
                    handleEvent(event);
                }

                // if the watched directory gets deleted, get out of run method
                if (!watchKey.reset()) {
                    System.out.println("No longer valid");
                    watchKey.cancel();
                    watchService.close();
                    break;
                }
            }

        } catch (InterruptedException exception) {
            System.out.println("interrupted. Goodbye");
            return;
        } catch (IOException exception) {
            return;
        }
    }
}
