package com.boggle;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.boggle.BoggleWordGenerator.explore;

public class TestingBoggleWordGenerator {

    @Test
    public void test_explore() throws IOException {
        char[][] board = {
                {'w', 's', 'r', 'e', 'o'},
                {'f', 'v', 'y', 'y', 'm'},
                {'u', 'i', 'r', 'p', 'e'},
                {'t', 'n', 't', 'c', 'd'},
                {'f', 's', 'h', 'i', 'o'},
        };
        List<String> testList = new ArrayList<>();
        WordPrefixCalculator exploreTestWordPrefixCalculator = new WordPrefixCalculator("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        FullWordCalculator exploreTestFullWordCalculator = new FullWordCalculator("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        for (int i = 0; i < 5; i++){
            for (int a = 0; a < 5; a++){
                BoggleLetter newBogLetter = new BoggleLetter(i,a, board[i][a]);
                explore(newBogLetter, "", board, testList, exploreTestFullWordCalculator,exploreTestWordPrefixCalculator);
            }
        }

        for (int b = 0; b < testList.size(); b++){
            System.out.println(testList.get(b));
        }
    }
}
