package com.boggle;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FullWordCalculator {

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
        List<String> words = readFileInList("/Users/natashasinghvi/Documents/boggle/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        Boolean answer = checkIsWordFull("djlk");
        System.out.println(answer);

    }

    public static Boolean checkIsWordFull(String word) {

        List<String> words = readFileInList("/Users/natashasinghvi/Documents/boggle/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        HashSet<String> listOfWordsSet = new HashSet<>();
        listOfWordsSet.addAll(words);

        if (listOfWordsSet.contains(word)){
            return true;
        }
        else{
            return false;
        }
    }
}
