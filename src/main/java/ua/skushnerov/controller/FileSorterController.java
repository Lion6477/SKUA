// Copyright 2024 Serhii Kushnerov
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at serhiikushnerov@gmail.com
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package ua.skushnerov.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import ua.skushnerov.exception.EmptyDirectoryPathException;
import ua.skushnerov.exception.InvalidDirectoryPathException;
import ua.skushnerov.exception.NoDirectorySelectedException;
import ua.skushnerov.service.Sorter;
import ua.skushnerov.service.FolderPathValidator;

import java.io.File;

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
        if (!FolderPathValidator.isValidDirectoryPath(directoryPath)) {
            System.out.println("Invalid directory path");
            resultTextField.setText("Error: Invalid directory path!");
            throw new InvalidDirectoryPathException();
        }

        Sorter.sortFilesByExtension(directoryPath);

        System.out.println("Sorted directory: " + directoryPath);
        resultTextField.setText("Sorted directory: " + directoryPath);
    }
}


