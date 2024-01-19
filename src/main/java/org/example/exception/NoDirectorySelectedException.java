package org.example.exception;

public class NoDirectorySelectedException extends RuntimeException {
    public NoDirectorySelectedException() {
        super("No directory selected!");
    }
}
