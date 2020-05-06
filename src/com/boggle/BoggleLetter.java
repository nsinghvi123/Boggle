package com.boggle;

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

    
}


