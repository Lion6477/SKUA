package org.example.exception;

public class InvalidDirectoryPathException extends RuntimeException {
    public InvalidDirectoryPathException() {
        super("Invalid directory path!");
    }
}
