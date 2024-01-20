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
package ua.skushnerov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.skushnerov.config.manager.SceneManager;

public class FileSorterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager.getInstance().setPrimaryStage(primaryStage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/fileSorter.fxml"));
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("File Sorter");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}


