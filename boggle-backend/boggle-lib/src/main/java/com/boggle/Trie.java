package com.boggle;

import com.google.cloud.vision.v1.Word;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        Tree currentFirstLetter = new Tree();
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

    public List<String> allWords() throws IOException {
        Node currentNode = null;
        Map<Character,Tree> alphabetMapLetters = new HashMap<>();
        Map<Character,Tree> randomMap = new HashMap<>();
        FullWordCalculator newFullWordCalculator = new FullWordCalculator("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        alphabetMapLetters = this.alphabetMap;
        Trie prefixCalculator = new Trie(randomMap);
        List<String> allWords = new ArrayList<>();
        for (Map.Entry<Character, Tree> entry : alphabetMapLetters.entrySet()) {
            String path = "";
            Tree currentStartLetter = entry.getValue();
            path += entry.getKey();
            allWords.addAll(currentStartLetter.exploreNode(path, newFullWordCalculator, prefixCalculator, allWords, currentNode));
        }
        return allWords;
    }
}

//for (int i = 0; i < alphabetMapLetters.size(); i++){
//            String path = "";
//            Tree currentStartLetter = alphabetMapLetters.get(i);
//            // How do I add the root character for the Tree currentStartLetter to my path?
//            path += currentStartLetter.toString();
//            allWords.addAll(currentStartLetter.exploreNode(path, newFullWordCalculator, prefixCalculator, allWords, currentNode));
//        }
