package com.boggle;

public class BoggleLetterTest {

    public static void main(String[] args) {
        BoggleLetter boggleLetter = new BoggleLetter(0, 2, 't');
        String[][] board = {
                {"d ", "h", "t", "m", "e"},
                {"o ", "f", "o", "d", "l"},
                {"i ", "g", "b", "a", "c"},
                {"r ", "s", "e", "m", "r"},
                {"e ", "t", "h", "n", "p"},
        };
        System.out.println(boggleLetter.adjacentLetters(board));

    }
}
