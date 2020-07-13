package com.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BoggleLetterTestJunit {

    @Test
    public void test_BoggleLetterGetters() {
        BoggleLetter boggleLetter = new BoggleLetter(2, 1, 'd');
        Assert.assertEquals(boggleLetter.getRow(), 2);
        Assert.assertEquals(boggleLetter.getCol(), 1);
        Assert.assertEquals(boggleLetter.getVal(), 'd');
    }

    @Test
    public void test_AdjacentPositions(){
        char[][] board = {
                {'d', 'h', 't', 'm', 'e'},
                {'o', 'f', 'o', 'd', 'l'},
                {'i', 'g', 'b', 'a', 'c'},
                {'r', 's', 'e', 'm', 'r'},
                {'e', 't', 'h', 'n', 'p'},
        };
        BoggleLetter boggleLetter = new BoggleLetter(0,0,'d');
        List<BoggleLetter> lettersToExplore = boggleLetter.adjacentLetters(board);
        Assert.assertEquals(lettersToExplore.get(0).getRow(), 0);
        Assert.assertEquals(lettersToExplore.get(0).getCol(), 1);
        Assert.assertEquals(lettersToExplore.get(0).getVal(), 'h');
        Assert.assertEquals(lettersToExplore.get(1).getRow(), 1);
        Assert.assertEquals(lettersToExplore.get(1).getCol(), 0);
        Assert.assertEquals(lettersToExplore.get(1).getVal(), 'o');
        Assert.assertEquals(lettersToExplore.get(2).getRow(), 1);
        Assert.assertEquals(lettersToExplore.get(2).getCol(), 1);
        Assert.assertEquals(lettersToExplore.get(2).getVal(), 'f');
    }
}
