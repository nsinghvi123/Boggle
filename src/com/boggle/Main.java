package com.boggle;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        char[][] board = {
                {'d', 'h', 't', 'm', 'e'},
                {'o', 'f', 'o', 'd', 'l'},
                {'i', 'g', 'b', 'a', 'c'},
                {'r', 's', 'e', 'm', 'r'},
                {'e', 't', 'h', 'n', 'p'},
        };

        BoggleLetter newBogLetter = new BoggleLetter(0, 0, 'd');

        explore(newBogLetter, "", board);



    }

    public static void explore(BoggleLetter boggleLetter, String path, char board[][]) {
        // when i start, i explore the current letter
        path += boggleLetter.getVal();
        // figures out all the accessible options to the current letter
        List<BoggleLetter> lettersToExplore = boggleLetter.adjacentLetters(board);
        // checks if the word is a prefix
        Boolean isPrefix = WordPrefixCalculator.checkIsWordPrefix(path);
        // checks if the word is a full word
        Boolean isWordFull = FullWordCalculator.checkIsWordFull(path);

        if (isWordFull){
            System.out.println(path);
        }
        if (isPrefix) {
            for (int i = 0; i < lettersToExplore.size(); i++) {
                explore(lettersToExplore.get(i), path, board);
            }
        }
    }
}

    // base case: it not a prefix, not call explore and return something
    // 2nd case: if it is a full word, then print it out (refer to that function)
    // 3rd case: find all the adjacent letters and call explore






