package org.example.exception;

public class EmptyDirectoryPathException extends RuntimeException {
    public EmptyDirectoryPathException() {
        super("Directory path is empty");
    }
}
