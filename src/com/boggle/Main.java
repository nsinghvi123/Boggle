package com.boggle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

       explore(0,0, "");


    }

    public static String position(int row, int col){
        String corner = "corner";
        String middle = "middle";
        String side = "side";
        String actual = "";

        if (row == 0 && col == 0 || row == 0 && col == 4 || row == 4 && col == 0 || row == 4 && col == 4){
            actual = corner;
        }

        else if (row == 1 && col == 1 || row == 1 && col == 2 || row == 1 && col == 3){
            actual = middle;
        }

        else if (row == 2 && col == 1 || row == 2 && col == 2 || row == 2 && col == 3) {
            actual = middle;
        }

        else if (row == 3 && col == 1 || row == 3 && col == 2 || row == 3 && col == 3){
            actual = middle;
        }

        else {
            actual = side;

            if (row == 0 && col == 1 || row == 0 && col == 2 || row == 0 && col == 3){
                actual += " Upper";
            }
            else if (row == 0 && col == 1 || row == 0 && col == 2 || row == 0 && col == 3){
                actual += " Left";
            }
            else if (row == 4 && col == 1 || row == 4 && col == 2 || row == 4 && col == 3){
                actual += " Right";
            }
            else {
                actual += " Lower";
            }
        }

        return actual;

    }

    public static String explore(int row, int col, String path){

        //Created a 5 by 5 Char Array
        String[][] wordArray = new String[5][5];

        //Added Char Elements
        wordArray[0][0] = "d";
        wordArray[0][1] = "h";
        wordArray[0][2] = "t";
        wordArray[0][3] = "m";
        wordArray[0][4] = "e";
        wordArray[1][0] = "o";
        wordArray[1][1] = "f";
        wordArray[1][2] = "o";
        wordArray[1][3] = "d";
        wordArray[1][4] = "l";
        wordArray[2][0] = "i";
        wordArray[2][1] = "g";
        wordArray[2][2] = "b";
        wordArray[2][3] = "a";
        wordArray[2][4] = "c";
        wordArray[3][0] = "r";
        wordArray[3][1] = "s";
        wordArray[3][2] = "e";
        wordArray[3][3] = "m";
        wordArray[3][4] = "r";
        wordArray[4][0] = "e";
        wordArray[4][1] = "t";
        wordArray[4][2] = "h";
        wordArray[4][3] = "n";
        wordArray[4][4] = "p";

        String pos = position(row,col);
        Boolean answer = true;

        if (pos == "corner"){

            if (row == 0 && col == 0) {

                path = path + wordArray[0][0];

                for (int i = 0; i <= 1; ++i) {

                    for (int a = 0; a <= 1; ++a) {

                        if (i != 0 || a != 0) {
                            path += wordArray[i][a];
                            answer = checkString(path);
                            if (answer == true) {
                                System.out.println(path);
                                explore(i, a, path);

                            }

                        }
                    }
                }
            }
            else if (row == 0 && col == 4){

                path += wordArray[0][4];

                for (int i = 0; i <= 1; ++i){

                    for (int a = 4; a >= 3; --a){

                        if (i != 0 && a != 4) {
                            path += wordArray[i][a];
                            answer = checkString(path);
                            if (answer == true) {
                                System.out.println(path);
                                explore(i, a, path);

                            }

                        }
                    }
                }
                }
            else if (row == 4 && col == 0){
                path += wordArray[4][0];

                for (int i = 4; i >= 3; --i){

                    for (int a = 0; a >= 1; ++a){

                        if (i != 4 && a != 0) {
                            path += wordArray[i][a];
                            answer = checkString(path);
                            if (answer == true) {
                                System.out.println(path);
                                explore(i, a, path);

                            }

                        }
                    }
                }
            }
            else if (row == 4 && col == 4){
                path += wordArray[4][4];

                for (int i = 4; i >= 3; --i){

                    for (int a = 3; a <= 4; ++a){
                        if (i != 4 && a != 4) {
                            path += wordArray[i][a];
                            answer = checkString(path);
                            if (answer == true) {
                                System.out.println(path);
                                explore(i, a, path);

                            }

                        }
                    }
                }
            }
        }

        else if (pos == "middle"){
            path += wordArray[row][col];

            for (int i = row - 1 ; i <= row + 1; i++){

                for (int a = col - 1; a <= col + 1; a++){

                    if (i != row && a != col){
                        path += wordArray[i][a];
                        answer = checkString(path);
                        if (answer = true){
                            System.out.println(path);
                            explore(i,a, path);
                        }
                    }
                }
            }
        }

        else {
            path += wordArray[row][col];
            if (pos == "side Upper"){

                for (int i = row; i <= row + 1; i++){
                    for (int a = col - 1; a <= col+1; a++){
                        if (i!= row && a!= col){
                            path += wordArray[i][a];
                            answer = checkString(path);
                            if (answer == true){
                                System.out.println(path);
                                explore(i,a, path);
                            }
                        }
                    }
                }


            }

            else if (pos == "side Right"){

                for (int i = row - 1; i <= row + 1; i++){
                    for (int a = col - 1; a <= col; a++){
                        if (i!= row && a!= col){
                            path += wordArray[i][a];
                            answer = checkString(path);
                            if (answer == true){
                                System.out.println(path);
                                explore(i,a, path);
                            }
                        }
                    }
                }




            }
            else if (pos == "side Lower"){

                for (int i = row - 1; i <= row; i++){
                    for (int a = col - 1; a <= col+1; a++){
                        if (i!= row && a!= col){
                            path += wordArray[i][a];
                            answer = checkString(path);
                            if (answer == true){
                                System.out.println(path);
                                explore(i,a, path);
                            }
                        }
                    }
                }


            }

            else if (pos == "side Left"){

                for (int i = row - 1; i <= row + 1; i++){
                    for (int a = col; a <= col+1; a++){
                        if (i!= row && a!= col){
                            path += wordArray[i][a];
                            answer = checkString(path);
                            if (answer == true){
                                System.out.println(path);
                                explore(i,a, path);
                            }
                        }
                    }
                }
            }
        }
        return path;
    }

    public static Boolean checkString(String word) {

        //size of ArrayList
        int n = 8;
        String checkWord = "";
        Boolean choice = false;

        //declaring ArrayList of size n
        ArrayList<String> stringArray = new ArrayList<String>(n);

        //adding string elements to ArrayList
        stringArray.add("dog");
        stringArray.add("fish");
        stringArray.add("fire");
        stringArray.add("home");
        stringArray.add("hoes");
        stringArray.add("team");
        stringArray.add("current");
        stringArray.add("socks");

        //loop to access elements of ArrayList
        for (int i = 0; i < n; i++) {
            checkWord = stringArray.get(i);

            for (int a = 0;  a < word.length(); a++){

                if (word.charAt(a) == checkWord.charAt(a)){
                    choice = true;
                    return true;
                }
            }
        }
        return choice;
    }
}

