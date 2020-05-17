package com.boggle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordPrefixCalculator {

    public static List<String> readFileInList(String fileName) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }


    public static void main(String[] args) {
        List<String> words = readFileInList("/Users/natashasinghvi/Documents/boggle/src/main/java/com/boggle/listOfWords.txt");
    }

    public static Boolean checkIsWordPrefix(String prefix){
        List<String> words = readFileInList("/Users/natashasinghvi/Documents/boggle/src/main/java/com/boggle/listOfWords.txt");

        for (int i = 0; i < words.size(); i++) {
            boolean wordHasPrefix = checkWordHasPrefix(prefix, words.get(i));
            if (wordHasPrefix) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkWordHasPrefix(String prefix, String fullWord) {
        int count = 0;
        if (fullWord.length() >= prefix.length()){
            for (int a = 0; a < prefix.length(); a++){
                if (prefix.charAt(a) == fullWord.charAt(a)){
                    count++;
                }
                if (count == prefix.length()){
                    return true;
                }
            }

        }

        return false;
    }
}
