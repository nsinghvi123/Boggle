package com.boggle;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TrieTest {

    @Test
    public void testTrie() throws IOException {
        Trie testTrie = Trie.createTrie("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        List<String> finalWordsCreated = testTrie.allWords();
        FullWordCalculator newFullWordCalculator = new FullWordCalculator("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        for (int i = 0; i < finalWordsCreated.size(); i++){
            Boolean isWordFull = newFullWordCalculator.checkIsWordFull(finalWordsCreated.get(i));
            if (isWordFull){
                System.out.println(finalWordsCreated.get(i));

            }
        }

    }

}
