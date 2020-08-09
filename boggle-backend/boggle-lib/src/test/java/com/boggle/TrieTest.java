package com.boggle;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TrieTest {

    @Test
    public void testTrie() throws IOException {
        Trie testTrie = Trie.createTrie("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        List<String> finalWordsCreated = testTrie.allWords();
        Boolean answer = testTrie.isPrefix("sre");
        Boolean loser = testTrie.isPrefix("t");
        Boolean five = testTrie.isPrefix("hi");
        Boolean siz = testTrie.isPrefix("oijsdf");
        Boolean losers = testTrie.isPrefix("toast");
        Boolean sdven = testTrie.isPrefix("pr");

        FullWordCalculator newFullWordCalculator = new FullWordCalculator("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        for (int i = 0; i < finalWordsCreated.size(); i++){
            Boolean isWordFull = newFullWordCalculator.checkIsWordFull(finalWordsCreated.get(i));
            if (isWordFull){
                System.out.println(finalWordsCreated.get(i));

            }
        }

    }

}
