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
