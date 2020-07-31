package com.boggle;

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

    public List<String> getAllWordsInTree(char startLetter){
        String path = "";
        List<String> wordsPerTree = new ArrayList<>();
        Node currentNode = root;
        Map<Character, Node> characterToNode = new HashMap<>();
        characterToNode = currentNode.getChildren();
        path += startLetter;
        createWordsPerTree(path, wordsPerTree, currentNode);
        return wordsPerTree;
    }

    private void createWordsPerTree(String path, List<String> words, Node currentNode){
        String original = path;
        Map<Character, Node> characterToNode = new HashMap<>();
        characterToNode = currentNode.getChildren();
            for (Map.Entry<Character, Node> entry : characterToNode.entrySet()){
                path = original;
                path += entry.getKey();
                if (entry.getValue().hasChildren()){
                    currentNode = entry.getValue();
                    createWordsPerTree(path, words, currentNode);
                }
                else {
                    words.add(path);
                }
            }
        }
    }
