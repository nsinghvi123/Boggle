package com.boggle;

import java.util.ArrayList;
import java.util.List;

public class BoggleLetter {
    private int row;
    private int col;
    private char val;

    public BoggleLetter (int row, int col, char val){
        this.row = row;
        this.col = col;
        this.val = val;
    }

    public int getRow() {
        return row;
    }

    public int getCol(){
        return col;
    }

    public char getVal(){
        return val;
    }

    public List<BoggleLetter> adjacentLetters(String[][] board) {
        List<BoggleLetter> result = new ArrayList<>();
        for (int i = row - 1; i <= row + 1; i++){
          for (int a = col - 1; a <= col + 1; a++){
              if (i < 0 || a < 0 || i >= board.length || a >= board.length){
                  continue;
              } else if (i == row && a == col) {
                  continue;
              }
              result.add(new BoggleLetter(i, a, board[i][a]));
          }
        }
        return null;
    }
}


