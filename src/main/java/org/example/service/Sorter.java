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
package org.example.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Sorter {

    public static void sortFilesByExtension(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // Структура для хранения файлов по расширению
        HashMap<String, List<File>> fileMap = new HashMap<>();

        // Группировка файлов по расширению
        for (File file : files) {
            if (file.isFile()) {
                String extension = getFileExtension(file);
                fileMap.computeIfAbsent(extension, k -> new ArrayList<>()).add(file);
            }
        }

        // Сортировка файлов внутри каждой группы
        fileMap.forEach((extension, fileList) -> {
            fileList.sort((f1, f2) -> f1.getName().compareTo(f2.getName()));
        });

        // Перемещение файлов в новые каталоги
        for (String extension : fileMap.keySet()) {
            File extensionDirectory = new File(directoryPath + "/" + extension);
            if (!extensionDirectory.exists()) {
                extensionDirectory.mkdir();
            }

            for (File file : fileMap.get(extension)) {
                File newFile = new File(extensionDirectory.getPath() + "/" + file.getName());
                file.renameTo(newFile);
            }
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}

