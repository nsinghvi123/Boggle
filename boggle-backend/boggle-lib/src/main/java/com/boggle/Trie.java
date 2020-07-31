package com.boggle;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Map<Character,Tree> alphabetMap = new HashMap<Character,Tree>();

    public Trie(){
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

}
