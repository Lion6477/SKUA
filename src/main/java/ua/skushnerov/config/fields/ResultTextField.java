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
package ua.skushnerov.config.fields;

import javafx.scene.control.TextField;

public class ResultTextField extends TextField {

    private static TextField instance;

    private ResultTextField() {

    }

    public static TextField getInstance() {
        if (instance == null) {
            instance = new TextField();
        }
        return instance;
    }
}