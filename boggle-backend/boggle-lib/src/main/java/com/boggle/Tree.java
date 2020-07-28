package com.boggle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree {
    private Node root;

    public Tree(){
        this.root = new Node();
    }

    public boolean isPrefix(String word){
        Node currentNode = root;
        for (int i = 1; i < word.length(); i++){
            char currentLetter = word.charAt(i);
            currentNode.getChildren();
            if (currentNode.childHasLetter(currentLetter) == true){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public void createTree(String word){
        Node currentNode = root;
        Map<Character, Node> characterToNode = new HashMap<>();
        for (int i = 1; i < word.length(); i++){
            characterToNode = currentNode.getChildren();
            if (characterToNode.containsKey(word.charAt(i))){
                currentNode = characterToNode.get(word.charAt(i));
            }
            else{
                currentNode.createNode(word.charAt(i));
                currentNode = characterToNode.get(word.charAt(i));
            }
        }
    }

    public List<String> exploreNode(String path, FullWordCalculator newFullWordCalculator, Trie prefixCalculator, List<String> wordsCreated, Node currentNode) throws IOException {
        Map<Character, Node> characterToNode = new HashMap<>();
        characterToNode = root.getChildren();
        for (int i = 0; i < characterToNode.size(); i++){
            for (Character key : characterToNode.keySet()) {
                path += key;
                Boolean isPrefix = prefixCalculator.isPrefix(path);
                Boolean isFullWord = newFullWordCalculator.checkIsWordFull(path);
                if (isFullWord){
                    wordsCreated.add(path);
                }
                if (isPrefix) {
                    currentNode = characterToNode.get(key);
                    characterToNode = currentNode.getChildren();
                    for (int j = 0; j < characterToNode.size(); j++){
                        exploreNode(path, newFullWordCalculator, prefixCalculator, wordsCreated, currentNode);
                    }
                }
            }

        }
        return wordsCreated;
    }
}
