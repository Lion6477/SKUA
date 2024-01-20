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
package ua.skushnerov.service;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyService {
    public CopyService() {
    }

    public void copyElements(String sourcePath, String destinationPath, TextField resultTextField) {
        Thread copyThread = new Thread(() -> {
            try {
                Path sourceDir = Paths.get(sourcePath);
                Path destinationDir = Paths.get(destinationPath);

                if (!Files.exists(sourceDir)) {
                    resultTextField.setText("Source directory does not exist!");
                    return;
                }

                if (!Files.exists(destinationDir)) {
                    Files.createDirectories(destinationDir);
                }

                Files.walk(sourceDir)
                        .forEach(source -> {
                            try {
                                Path destination = destinationDir.resolve(sourceDir.relativize(source));
                                if (!Files.exists(destination)) {
                                    resultTextField.setText("Copying: " + source);

                                    if (Files.isDirectory(source)) {
                                        Files.createDirectories(destination);
                                    } else {
                                        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                resultTextField.setText("Files copied successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                resultTextField.setText("Error during file copy");
            }
        });
        System.out.println("Copying elements from " + sourcePath + " to " + destinationPath);
        copyThread.start();
    }
}
