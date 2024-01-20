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
import ua.skushnerov.controller.defoult.SceneManager;
import ua.skushnerov.controller.defoult.actions.Browse;
import ua.skushnerov.controller.defoult.fields.ResultTextField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyPageController {
    @FXML
    private TextField resultTextField = ResultTextField.getInstance();

    @FXML
    private TextField sourceDirectoryField;

    @FXML
    private TextField destinationDirectoryField;
    private Browse browsebutton = new Browse();


    private SceneManager sceneManager = SceneManager.getInstance();


    @FXML
    private void copyFiles() {
        String sourcePath = sourceDirectoryField.getText();
        String destinationPath = destinationDirectoryField.getText();

        try {
            Path sourceDir = Paths.get(sourcePath);
            Path destinationDir = Paths.get(destinationPath);

            // Проверяем, что исходная директория существует
            if (!Files.exists(sourceDir)) {
                resultTextField.setText("Source directory does not exist!");
                return;
            }

            // Создаем директорию назначения, если она не существует
            if (!Files.exists(destinationDir)) {
                Files.createDirectories(destinationDir);
            }

            // Копируем все файлы и поддиректории из исходной директории в директорию назначения
            Files.walk(sourceDir)
                    .forEach(source -> {
                        try {
                            Path destination = destinationDir.resolve(sourceDir.relativize(source));
                            if (!Files.exists(destination)) {
                                System.out.println("Copying: " + source);
                                System.out.println("To: " + destination);

                                if (Files.isDirectory(source)) {
                                    // Если это директория, создаем соответствующую директорию в директории назначения
                                    Files.createDirectories(destination);
                                } else {
                                    // Если это файл, копируем его в директорию назначения
                                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            resultTextField.setText("Files copied successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            resultTextField.setText("Error during file copy");
        }
    }

    @FXML
    private void navigateToFileSorter() {
        sceneManager.switchScene("/fxml/FileSorter.fxml", "File Sorter");
        resultTextField.setText("Navigating to File Sorter");
    }

    @FXML
    private void navigateToCopyPage() {
        sceneManager.switchScene("/fxml/CopyPage.fxml", "Copy Page");
        resultTextField.setText("Navigating to Copy Page");
    }

    public void browseSourceDirectoryButtonClicked(ActionEvent event) {
        browsebutton.browse(event, resultTextField, sourceDirectoryField);
        System.out.println("browseSourceDirectoryButtonClicked");
    }

    public void browseDestinationDirectoryButtonClicked(ActionEvent event) {
        browsebutton.browse(event, resultTextField, destinationDirectoryField);
        System.out.println("browseDestinationDirectoryButtonClicked");
    }
}
