import com.boggle.Vertex;

import java.util.*;

public class CheckVertexRepetitionTest {
    private Map<Vertex, Character> map = new HashMap<>();
    private Map<String,Character> alreadyProcessedVertices = new HashMap<>();
    private Map<Vertex, Character> finalMap = new HashMap<>();

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
        CheckVertexRepetitionTest newVertex = new CheckVertexRepetitionTest(testMap);
        newVertex.checkVertexRepetition(testMap);


    }

    public CheckVertexRepetitionTest(Map currentMap){
        this.map = currentMap;
    }

    public void checkVertexRepetition(Map<Vertex, Character> allAnnotatedEntries){
        int highest = 0;
        Character mostFrequentLetter = null;
        List<Character> sameVertexLetter = new ArrayList<>();

        for (Map.Entry<Vertex,Character> entry : allAnnotatedEntries.entrySet()){
            int count = 0;
            int x = entry.getKey().getX();
            int y = entry.getKey().getY();
            Character letter = entry.getValue();
            Vertex original = new Vertex(x, y);

            if (alreadyProcessedVertices.containsKey(original.toString())) {
                continue;
            }
            else {
                alreadyProcessedVertices.put(original.toString(), letter);
                for (Map.Entry<Vertex,Character> entryOne : allAnnotatedEntries.entrySet()){
                    int anotherX = entryOne.getKey().getX();
                    int anotherY = entryOne.getKey().getY();
                    Character anotherLetter = entryOne.getValue();
                    if (anotherX == x && anotherY == y) {
                        sameVertexLetter.add(anotherLetter);
                        count++;
                    }
                }
                if (count > 1){
                    for (int i = 0; i < sameVertexLetter.size(); i++){
                        int num = Collections.frequency(sameVertexLetter, sameVertexLetter.get(i));
                        if (num > highest){
                            highest = num;
                            mostFrequentLetter = sameVertexLetter.get(i);
                        }
                        else {
                            mostFrequentLetter = null;
                        }
                    }
                    Vertex newVertex = new Vertex(x, y);
                    finalMap.put(newVertex, mostFrequentLetter);
                    alreadyProcessedVertices.put(newVertex.toString(), mostFrequentLetter);
                }
                else {
                    Vertex sameVertex = new Vertex(x, y);
                    finalMap.put(sameVertex, letter);
                    alreadyProcessedVertices.put(sameVertex.toString(), letter);
                }
                sameVertexLetter.clear();
                highest = 0;
            }
        }
    }
}