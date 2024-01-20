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
import ua.skushnerov.config.actions.Browse;
import ua.skushnerov.config.fields.ResultTextField;
import ua.skushnerov.config.manager.SceneChanger;
import ua.skushnerov.config.manager.SceneManager;
import ua.skushnerov.service.SorterService;

public class FileSorterController {
    SorterService sorterService = new SorterService();
    SceneChanger sceneChanger = SceneChanger.getInstance();

    @FXML
    private TextField directoryTextField;
    @FXML
    private TextField resultTextField = ResultTextField.getInstance();

    private Browse browsebutton = new Browse();

    private SceneManager sceneManager = SceneManager.getInstance();

    @FXML
    private void initialize() {
        System.out.println("Started");
    }

    @FXML
    private void browseButtonClicked(ActionEvent event) {
        browsebutton.browse(resultTextField, directoryTextField);
    }

    @FXML
    private void sortFilesButtonClicked(ActionEvent event) {
        String directoryPath = directoryTextField.getText();

        sorterService.sortFilesByExtension(directoryPath);
        resultTextField.setText("Sorted directory: " + directoryPath);
    }

    @FXML
    private void navigateToFileSorter() {
        sceneChanger.toFileSorterScene();
        resultTextField.setText("Navigating to File Sorter");
    }

    @FXML
    private void navigateToCopyPage() {
        sceneChanger.toCopyPageScene();
        resultTextField.setText("Navigating to Copy Page");
    }
}



