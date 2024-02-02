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

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import ua.skushnerov.config.manage.PageChanger;
import ua.skushnerov.service.CopyService;
import ua.skushnerov.service.SorterService;

import java.net.URL;
import java.util.ResourceBundle;

public class SKUAController implements Initializable {
    private SorterService sorterService = SorterService.getInstance();
    private PageChanger pageChanger = PageChanger.getInstance();
    private CopyService copyService = CopyService.getInstance();

    @FXML
    private TextField directoryTextField;
    @FXML
    private Button browseButton;
    @FXML
    private Button sortFiles;
    @FXML
    private TextField resultTextField;
    @FXML
    private Button fileSorterButton;
    @FXML
    private Button copyPageButton;
    @FXML
    private AnchorPane sortFilesContentPage;
    @FXML
    private AnchorPane copyFandDContentPage;
    @FXML
    private TextField sourceDirectoryTextField;
    @FXML
    private Button browseSourceDirectoryButton;
    @FXML
    private TextField destinationDirectoryTextField;
    @FXML
    private Button browseDestinationDirectoryButton;
    @FXML
    private Button startCopyingButton;
    @FXML
    private Button menu;
    @FXML
    private Button menuClose;
    @FXML
    private AnchorPane slider;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        browseButton.setOnMouseClicked(event -> {
            sorterService.browse(directoryTextField, resultTextField);
        });

        sortFiles.setOnMouseClicked(event -> {
            String directoryPath = directoryTextField.getText();

            sorterService.sortFilesByExtension(directoryPath, resultTextField);
        });


        browseSourceDirectoryButton.setOnMouseClicked(event -> {
            sorterService.browse(sourceDirectoryTextField, resultTextField);
        });

        browseDestinationDirectoryButton.setOnMouseClicked(event -> {
            sorterService.browse(destinationDirectoryTextField, resultTextField);
        });

        startCopyingButton.setOnMouseClicked(event -> {
            String sourcePath = sourceDirectoryTextField.getText();
            String destinationPath = destinationDirectoryTextField.getText();

            copyService.copyElements(sourcePath, destinationPath, resultTextField);
        });

        //Menu here
        slider.setTranslateX(-200);

        menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-200);

            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(false);
                menuClose.setVisible(true);
            });
        });

        menuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-200);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(true);
                menuClose.setVisible(false);
            });
        });


        //Change page from copyFandDContentPage to sortFilesContentPage
        fileSorterButton.setOnMouseClicked(event -> {
            pageChanger.pageChange(copyFandDContentPage, sortFilesContentPage);
            resultTextField.setText("Navigating to File Sorter page");
        });

        //Change page from sortFilesContentPage to copyFandDContentPage
        copyPageButton.setOnMouseClicked(event -> {
            pageChanger.pageChange(sortFilesContentPage, copyFandDContentPage);
            resultTextField.setText("Navigating to Copy F&D page");
        });
    }
}
