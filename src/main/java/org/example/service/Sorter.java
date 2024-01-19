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

