package com.boggle;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static com.boggle.BoggleBoardGenerator.returnBoggleBoard;
import static com.boggle.BoggleWordGenerator.generateWords;

public class BoggleBoardToWordTest {

    @Test
    public void testBoggleBoardToWord() throws IOException {
        Character[][] board = new Character[5][5];
        byte[] fileBytes = Files.readAllBytes(
                Paths.get("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/resources/IMG_0426.jpeg"));
        board = returnBoggleBoard(fileBytes);
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
        HashSet<String> allTheWords = generateWords(primitiveCharBoard);
        Iterator<String> it = allTheWords.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}