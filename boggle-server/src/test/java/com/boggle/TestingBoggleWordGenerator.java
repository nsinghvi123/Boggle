package com.boggle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.boggle.BoggleWordGenerator.explore;

public class TestingBoggleWordGenerator {

    @Test
    public void test_explore() {
        char[][] board = {
                {'w', 's', 'r', 'e', 'o'},
                {'f', 'v', 'y', 'y', 'm'},
                {'u', 'i', 'r', 'p', 'e'},
                {'t', 'n', 't', 'c', 'd'},
                {'f', 's', 'h', 'i', 'o'},
        };
        List<String> testList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            for (int a = 0; a < 5; a++){
                BoggleLetter newBogLetter = new BoggleLetter(i,a, board[i][a]);
                explore(newBogLetter, "", board, testList);
            }
        }

        for (int b = 0; b < testList.size(); b++){
            System.out.println(testList.get(b));
        }
    }
}
