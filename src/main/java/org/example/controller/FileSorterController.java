package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import org.example.exception.EmptyDirectoryPathException;
import org.example.exception.InvalidDirectoryPathException;
import org.example.exception.NoDirectorySelectedException;
import org.example.service.Sorter;

import java.io.File;

import static org.example.service.FolderPathValidator.isValidDirectoryPath;

public class FileSorterController {

    @FXML
    private TextField directoryTextField;
    @FXML
    private TextField resultTextField;

    @FXML
    private void initialize() {
        System.out.println("Started");
    }

    @FXML
    private void browseButtonClicked(ActionEvent event) {
        System.out.println("" + event.getTarget() + " " + event.getSource());
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Directory");
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory == null) {
            System.out.println("No directory selected");
            resultTextField.setText("Warning: No directory selected!");
            throw new NoDirectorySelectedException();

        } else {
            String inputPath = selectedDirectory.getAbsolutePath();
            directoryTextField.setText(inputPath);
            resultTextField.setText("Selected directory: " + inputPath);
        }
    }

    @FXML
    private void sortFilesButtonClicked(ActionEvent event) {
        System.out.println("" + event.getTarget() + " " + event.getSource());//logs
        String directoryPath = directoryTextField.getText();
        if (directoryPath.isEmpty()) {
            resultTextField.setText("Error: Directory path is empty!");
            throw new EmptyDirectoryPathException();
        }
        if (!isValidDirectoryPath(directoryPath)) {
            System.out.println("Invalid directory path");
            resultTextField.setText("Error: Invalid directory path!");
            throw new InvalidDirectoryPathException();
        }

        Sorter.sortFilesByExtension(directoryPath);

        System.out.println("Sorted directory: " + directoryPath);
        resultTextField.setText("Sorted directory: " + directoryPath);
    }
}


