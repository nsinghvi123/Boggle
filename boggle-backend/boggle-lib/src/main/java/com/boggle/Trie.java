package com.boggle;

import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        for (int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);

            TrieNode newNode = new TrieNode(letter);
        }

    }

}
