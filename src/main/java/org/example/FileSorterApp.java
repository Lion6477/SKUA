package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.controller.FileSorterController;

public class FileSorterApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/fileSorter.fxml"));
        Parent root = fxmlLoader.load();
        FileSorterController controller = fxmlLoader.getController();

        primaryStage.setTitle("File Sorter");
//        primaryStage.setScene(new Scene(root, 280, 170));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
