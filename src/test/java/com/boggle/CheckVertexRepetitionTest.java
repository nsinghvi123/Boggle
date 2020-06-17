package com.boggle;

import org.junit.Test;

import java.util.*;

public class CheckVertexRepetitionTest {
    private Map<Vertex, Character> map = new HashMap<>();
    private Map<String,Character> alreadyProcessedVertices = new HashMap<>();
    private Map<Vertex, Character> finalMap = new HashMap<>();

    @Test
    public static void main(String[] args) {
        Map<Vertex,Character> testMap = new HashMap<>();
        Vertex vertexOne = new Vertex (3, 2);
        Vertex vertexTwo = new Vertex (3, 2);
        Vertex vertexThree = new Vertex (3, 4);
        Vertex vertexFour = new Vertex (2, 2);
        Vertex vertexFive = new Vertex (4, 2);
        Vertex vertexSix = new Vertex (2, 3);
        Vertex vertexSeven = new Vertex(1, 3);
        Character firstLetter = 'a';
        Character secondLetter = 'b';
        Character thirdLetter = 'c';
        Character fourthLetter = 'd';
        Character fifthLetter = 'e';
        Character sixthLetter = 'f';
        testMap.put(vertexOne, firstLetter);
        testMap.put(vertexTwo, secondLetter);
        testMap.put(vertexThree, firstLetter);
        testMap.put(vertexFour, thirdLetter);
        testMap.put(vertexFive, fourthLetter);
        testMap.put(vertexSix, fifthLetter);
        BoggleBoardGenerator testingObject = new BoggleBoardGenerator();
        testingObject.checkVertexRepetition(testMap);
    }
}