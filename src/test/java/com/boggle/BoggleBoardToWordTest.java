package com.boggle;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.boggle.BoggleBoardGenerator.returnBoggleBoard;
import static com.boggle.BoggleWordGenerator.generateWords;

public class BoggleBoardToWordTest {

    @Test
    public void testBoggleBoardToWord() throws IOException {
        Character[][] board = new Character[5][5];
        board =  returnBoggleBoard("/Users/natashasinghvi/Documents/boggle/src/main/resources/TASHUPhotoboggle.jpeg");
        char[][] primitiveCharBoard = new char[5][5];
        for (int i = 0; i < 5; i++){
            for (int a = 0; a < 5; a++){
                Character characterToCopy = board[i][a];
                if (characterToCopy != null) {
                    characterToCopy = characterToCopy.toLowerCase(characterToCopy);
                    primitiveCharBoard[i][a] = characterToCopy;
                } else {
                    primitiveCharBoard[i][a] = '\0';
                }
            }
        }
        List<String> allTheWords = generateWords(primitiveCharBoard);
        for(int i = 0; i < allTheWords.size(); i++){
            System.out.println(allTheWords.get(i));
        }
    }
}