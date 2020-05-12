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
        List words = readFileInList("/Users/natashasinghvi/Documents/boggle/src/com/boggle/listOfWords.txt");
    }

    public static Boolean checkIsWordFull(String word) {
        int n = 8;
        int count = 0;



        //declaring ArrayList of size n
        ArrayList<String> fullWord = new ArrayList<String>(n);

        //adding string elements to ArrayList
        fullWord.add("dog");
        fullWord.add("fish");
        fullWord.add("fire");
        fullWord.add("home");
        fullWord.add("hoes");
        fullWord.add("team");
        fullWord.add("current");
        fullWord.add("socks");

        for (int i = 0; i < n; i++) {
            boolean wordIsFullWord = checkWordisFullWord(word, fullWord.get(i));
            if (wordIsFullWord) {
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
