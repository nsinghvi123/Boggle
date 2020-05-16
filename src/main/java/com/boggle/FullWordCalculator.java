package com.boggle;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
        List<String> words = readFileInList("/Users/natashasinghvi/Documents/boggle/src/main/java/com/boggle/listOfWords.txt");
        Boolean answer = checkIsWordFull("dog");
        System.out.println(answer);

    }

    public static Boolean checkIsWordFull(String word) {

        List<String> words = readFileInList("/Users/natashasinghvi/Documents/boggle/src/main/java/com/boggle/listOfWords.txt");

        //declaring ArrayList of size n
        for (int i = 0; i < words.size(); i++){
            boolean wordIsFullWord = checkWordisFullWord(word, words.get(i));
            if (wordIsFullWord){
                return true;
            }

        }
        return false;
    }


    public static Boolean checkWordisFullWord(String word, String completeWord){

        int count = 0;

        word = word.toLowerCase();
        completeWord = completeWord.toLowerCase();

        if (completeWord.length() >= word.length()){
            for (int i = 0; i < word.length(); i++){
                if (word.charAt(i) == completeWord.charAt(i)){
                    count++;
                }
                if (count == completeWord.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
