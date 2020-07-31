package com.boggle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordPrefixCalculator {
    private List<String> prefixDictionary = new ArrayList<>();

    public WordPrefixCalculator(String fileName) {
        try {
            this.prefixDictionary = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Boolean checkIsWordPrefix(String prefix){
        for (int i = 0; i < prefixDictionary.size(); i++) {
            boolean wordHasPrefix = checkWordHasPrefix(prefix, prefixDictionary.get(i));
            if (wordHasPrefix) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWordHasPrefix(String prefix, String fullWord) {
        int count = 0;
        if (fullWord.length() >= prefix.length()){
            for (int a = 0; a < prefix.length(); a++){
                if (prefix.charAt(a) == fullWord.charAt(a)){
                    count++;
                }
                if (count == prefix.length()){
                    return true;
                }
            }

        }

        return false;
    }
}
