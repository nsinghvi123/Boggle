package com.boggle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullWordCalculator {
    private Set<String> dictionary = new HashSet<>();

    public FullWordCalculator(String fileName) throws IOException {
        List<String> allWords = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        this.dictionary = new HashSet<>(allWords);
    }

    public Boolean checkIsWordFull(String word) {
        return dictionary.contains(word);
    }
}
