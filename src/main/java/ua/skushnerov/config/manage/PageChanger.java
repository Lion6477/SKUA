package ua.skushnerov.config.manage;

import javafx.scene.layout.AnchorPane;

public class PageChanger {
    private static PageChanger instance;
    private PageChanger() {

    }

    public static PageChanger getInstance() {
        if (instance == null) {
            instance = new PageChanger();
        }
        return instance;
    }

    public void pageChange(AnchorPane fromPage, AnchorPane toPage) {
        if (fromPage == null && toPage == null) {
            throw new NullPointerException("FromPage and ToPage can't be null");
        }
        else if (fromPage == null && toPage != null) {
            toPage.setVisible(true);
        }
        else if (fromPage != null && toPage == null) {
            fromPage.setVisible(false);
        }
        else if (fromPage != null && toPage != null) {
            fromPage.setVisible(false);
            toPage.setVisible(true);
        }
    }
}
