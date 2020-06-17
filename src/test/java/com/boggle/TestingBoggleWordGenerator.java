package com.boggle;
import org.junit.Assert;
import org.junit.Test;

public class TestingBoggleWordGenerator {

    @Test
    public void test_explore() {
        char[][] board = {
                {'d', 'h', 't', 'm', 'e'},
                {'o', 'f', 'o', 'd', 'l'},
                {'i', 'g', 'b', 'a', 'c'},
                {'r', 's', 'e', 'm', 'r'},
                {'e', 't', 'h', 'n', 'p'},
        };
        BoggleLetter newBogLetter = new BoggleLetter(0,0, board[0][0]);
       // explore(newBogLetter, "", board);
        // I am confused about how to test explore using the assert function




    }


}
