package org.example.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FolderPathValidator {

    public static boolean isValidDirectoryPath(String path) {
        String directoryPathRegex = "^(?:[a-zA-Z]:)?(?:[\\\\/][^\\\\/]+)*[\\\\/]?$";
        Pattern pattern = Pattern.compile(directoryPathRegex);
        Matcher matcher = pattern.matcher(path);
        return matcher.matches();
    }
}
