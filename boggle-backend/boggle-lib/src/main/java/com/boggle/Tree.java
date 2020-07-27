package com.boggle;

import java.util.HashMap;
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
}
