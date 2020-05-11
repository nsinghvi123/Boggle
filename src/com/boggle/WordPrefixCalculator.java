package com.boggle;

import java.util.ArrayList;

public class WordPrefixCalculator {

    public static void main(String[] args) {
        System.out.println(checkIsWordPrefix("do"));
    }

    public static Boolean checkIsWordPrefix(String prefix){
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
            boolean wordHasPrefix = checkWordHasPrefix(prefix, fullWord.get(i));
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
