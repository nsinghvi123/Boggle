package com.boggle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println(checkString("dog"));
        System.out.println(checkString("return"));
    }

    public static Boolean checkString(String word) {

        //size of ArrayList
        int n = 8;
        String checkWord = "";
        Boolean choice = false;

        //declaring ArrayList of size n
        ArrayList<String> stringArray = new ArrayList<String>(n);

        //adding string elements to ArrayList
        stringArray.add("dog");
        stringArray.add("fish");
        stringArray.add("fire");
        stringArray.add("home");
        stringArray.add("hoes");
        stringArray.add("team");
        stringArray.add("current");
        stringArray.add("socks");

        //loop to access elements of ArrayList
        for (int i = 0; i < n; i++) {
            checkWord = stringArray.get(i);

            if (word == checkWord){
                choice = true;
                return true;
            }
        }
        return choice;
    }
}

