package com.boggle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vertex {
     int x;
     int y;

    public Vertex(int xOne, int yOne){
        this.x = xOne;
        this.y = yOne;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
