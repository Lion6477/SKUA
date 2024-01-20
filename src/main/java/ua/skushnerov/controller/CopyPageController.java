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
import ua.skushnerov.service.CopyService;

public class CopyPageController {
    CopyService copyService = new CopyService();
    SceneChanger sceneChanger = SceneChanger.getInstance();

    @FXML
    private TextField resultTextField = ResultTextField.getInstance();

    @FXML
    private TextField sourceDirectoryField;

    @FXML
    private TextField destinationDirectoryField;
    private Browse browsebutton = new Browse();


    private SceneManager sceneManager = SceneManager.getInstance();


    @FXML
    private void copyButtonAction() {
        String sourcePath = sourceDirectoryField.getText();
        String destinationPath = destinationDirectoryField.getText();

        copyService.copyElements(sourcePath, destinationPath, resultTextField);

    }

    public void browseSourceDirectoryButtonClicked(ActionEvent event) {
        browsebutton.browse(event, resultTextField, sourceDirectoryField);
        System.out.println("browseSourceDirectoryButtonClicked");
    }

    public void browseDestinationDirectoryButtonClicked(ActionEvent event) {
        browsebutton.browse(event, resultTextField, destinationDirectoryField);
        System.out.println("browseDestinationDirectoryButtonClicked");
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
