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
        } else if (fromPage == null && toPage != null) {
            toPage.setVisible(true);
        } else if (fromPage != null && toPage == null) {
            fromPage.setVisible(false);
        } else if (fromPage != null && toPage != null) {
            fromPage.setVisible(false);
            toPage.setVisible(true);
        }
    }
}
