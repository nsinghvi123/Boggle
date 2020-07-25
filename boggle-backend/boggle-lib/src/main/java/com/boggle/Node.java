package com.boggle;

import java.util.HashMap;
import java.util.Map;

public class Node {

    private Map<Character, Node> children = new HashMap<Character, Node>();

    public Node(){
    }

    public Map<Character, Node> getChildren(){
        return children;
    }

    public boolean childHasLetter(char letter){
        if (children.containsKey(letter)) {
            return true;
        }
        else{
            return false;
        }
    }


}
