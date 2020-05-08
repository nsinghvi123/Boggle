package com.boggle;

import java.util.ArrayList;

public class FullWordCalculator {

    public static void main(String[] args) {
        System.out.println(checkIsWordFull("lie"));
        System.out.println(checkIsWordFull("dog"));
        System.out.println(checkIsWordFull("do"));



    }




    public static Boolean checkIsWordFull(String word){
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

        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == completeWord.charAt(i)){
                count++;
            }
            if (count == completeWord.length()){
                return true;
            }
        }
        return false;
    }
}
