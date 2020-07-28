package com.boggle;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TrieTest {

    @Test
    public void testTrie() throws IOException {
        Trie testTrie = Trie.createTrie("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        testTrie.getAlphabetMap();
        List<String> finalWordsCreated = testTrie.allWords();
        for (int i = 0; i < finalWordsCreated.size(); i++){
            System.out.println(finalWordsCreated.get(i));
        }

    }

}
