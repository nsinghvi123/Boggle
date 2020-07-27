package com.boggle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    private Map<Character,Tree> alphabetMap;

    public Trie(Map<Character, Tree> alphabetMap) {
        this.alphabetMap = alphabetMap;
    }

    public boolean isPrefix(String word){
        char firstLetter = word.charAt(0);
        Tree currentFirstLetter;
        currentFirstLetter = alphabetMap.get(firstLetter);
        if (currentFirstLetter.isPrefix(word)){
            return true;
        }
        else{
            return false;
        }
    }

    public Map<Character, Tree> getAlphabetMap() {
        return alphabetMap;
    }

    public static Trie createTrie(String fileName) throws IOException {
        Map<Character,Tree> alphabetMap = new HashMap<>();
        List<String> words = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (int i = 0; i < words.size(); i++) {
            if (!alphabetMap.containsKey(words.get(i).charAt(0))) {
                Tree newTree = new Tree();
                alphabetMap.put(words.get(i).charAt(0), newTree);
                newTree.createTree(words.get(i));
            }
            else{
                Tree currentTree = alphabetMap.get(words.get(i).charAt(0));
                currentTree.createTree(words.get(i));
            }
        }
        return new Trie(alphabetMap);
    }
}

