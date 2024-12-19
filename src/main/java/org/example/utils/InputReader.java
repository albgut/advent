package org.example.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class InputReader {
    public static String getStringFromFilePath(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<String>> getStringListFromFilePath(String filePath) {
        String rawInput = getStringFromFilePath(filePath);
        return Arrays.stream(rawInput.split("\r\n"))
                .map(s -> Arrays.stream(s.split("")).toList())
                .toList();
    }
}
