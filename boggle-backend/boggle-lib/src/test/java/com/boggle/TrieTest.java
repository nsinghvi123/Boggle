package com.boggle;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class TrieTest {

    @Test
    public void testTrie() throws IOException {
        Trie testTrie = Trie.createTrie("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        for (Map.Entry<Character, Tree> entry : testTrie.getAlphabetMap().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
        testTrie.getAlphabetMap();
    }

}
