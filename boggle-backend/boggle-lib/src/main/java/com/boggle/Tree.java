package com.boggle;

public class Tree {
    private Node root;

    public Tree(){

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
}
