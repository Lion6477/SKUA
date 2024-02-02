package ua.skushnerov.config.manage;

public class SceneChanger {
    private static SceneChanger instance;

    SceneManager sceneManager = SceneManager.getInstance();

    private SceneChanger() {

    }

    public static SceneChanger getInstance() {
        if (instance == null) {
            instance = new SceneChanger();
        }
        return instance;
    }

    public void toFileSorterScene() {
        sceneManager.switchScene("/fxml/FileSorter.fxml");
    }

    public void toCopyPageScene() {
        sceneManager.switchScene("/fxml/CopyPage.fxml", "Copy Page");
    }
}
