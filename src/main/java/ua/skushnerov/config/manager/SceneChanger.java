package ua.skushnerov.config.manager;

public class SceneChanger {
    private static SceneChanger instance;

    SceneManager sceneManager = SceneManager.getInstance();

    private SceneChanger() {
        // private конструктор для синглтона
    }

    public static SceneChanger getInstance() {
        if (instance == null) {
            instance = new SceneChanger();
        }
        return instance;
    }

    public void toFileSorterScene() {
        sceneManager.switchScene("/fxml/FileSorter.fxml", "File Sorter");
    }

    public void toCopyPageScene() {
        sceneManager.switchScene("/fxml/CopyPage.fxml", "Copy Page");
    }
}
