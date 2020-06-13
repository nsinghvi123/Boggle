package com.boggle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Image;
import com.google.protobuf.ByteString;

import javax.imageio.ImageIO;
import javax.swing.text.html.parser.Entity;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BoggleBoardGenerator {
    static Map<Vertex, Character> map = new HashMap<>();
    static Map<String,Character> alreadyProcessedVertices = new HashMap<>();
    static Map<Vertex, Character> finalMap = new HashMap<>();

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new Jdk8Module());

    public static byte[] extractBytes (String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage .getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

        return data.getData();
    }

    public static void main(String[] args) throws Exception {
        ImageSize newImageSize = calculateImageSize("/Users/natashasinghvi/Documents/boggle/src/main/resources/TASHUPhotoboggle.jpeg");
        int width = newImageSize.getWidth();
        int height = newImageSize.getHeight();
        Character[][] arrayLetter = new Character[5][5];

        List<EntityAnnotation> finalAnnotation = new ArrayList<EntityAnnotation>();
        finalAnnotation = returnAnnotationsViaGoogle("/Users/natashasinghvi/Documents/boggle/src/main/resources/TASHUPhotoboggle.jpeg");

        for (int i = 1; i < finalAnnotation.size(); i++){
            BoggleBoardGenerator boggleBoardGenerator = new BoggleBoardGenerator();
            BoggleAnnotations boggleAnnotations = new BoggleAnnotations(finalAnnotation.get(i), width, height, finalAnnotation.get(i).getDescription());
            int colMin = boggleAnnotations.findClosestLineNumber(boggleAnnotations.getTopLeftX(), boggleAnnotations.rowPixelIncrement);
            int colMax = boggleAnnotations.findClosestLineNumber(boggleAnnotations.getTopRightX(), boggleAnnotations.rowPixelIncrement);
            int rowMin = boggleAnnotations.findClosestLineNumber(boggleAnnotations.getTopRightY(), boggleAnnotations.colPixelIncrement);
            int rowMax = boggleAnnotations.findClosestLineNumber(boggleAnnotations.getBottomRightY(), boggleAnnotations.colPixelIncrement);
            List<Integer> arrayRow = boggleBoardGenerator.printAllInBetween(rowMin, rowMax);
            List<Integer> arrayCol = boggleBoardGenerator.printAllInBetween(colMin, colMax);
            boggleBoardGenerator.AllVertexCombinations(arrayRow, arrayCol, boggleAnnotations.description);
        }
        checkVertex newVertex = new checkVertex(map);
        arrayLetter = generateBoard(map);
        for (int i = 0; i < arrayLetter.length; i++){
            for (int a = 0; a < arrayLetter.length; a++){
                System.out.print(arrayLetter[i][a] + " ");
            }
            System.out.print("\n");
        }
    }

    public static List<EntityAnnotation> returnAnnotationsViaGoogle(String fileName){
        List <EntityAnnotation> realAnnotation = new ArrayList<EntityAnnotation>();
            // Instantiates a client
            try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {

                // Reads the image file into memory
                Path path = Paths.get(fileName);
                byte[] data = Files.readAllBytes(path);
                ByteString imgBytes = ByteString.copyFrom(data);

                // Builds the image annotation request
                List<AnnotateImageRequest> requests = new ArrayList<>();
                Image img = Image.newBuilder().setContent(imgBytes).build();
                Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
                AnnotateImageRequest request =
                        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
                requests.add(request);

                // Performs label detection on the image file
                BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
                List<AnnotateImageResponse> responses = response.getResponsesList();

                AnnotateImageResponse annotateImageResponse = responses.get(0);
                List<EntityAnnotation> annotations = annotateImageResponse.getTextAnnotationsList();
                realAnnotation = annotations;
                return annotations;
            } catch (IOException e) {
                e.printStackTrace();
            }
           return realAnnotation;
    }

    public static ImageSize calculateImageSize(String filename) throws IOException {
            BufferedImage bimg = ImageIO.read(new File("/Users/natashasinghvi/Documents/boggle/src/main/resources/TASHUPhotoboggle.jpeg"));
            int width = bimg.getWidth();
            int height = bimg.getHeight();
            ImageSize imagesize = new ImageSize(height, width);
            return imagesize;
    }

    public ArrayList printAllInBetween(int minimum, int maximum){
            List<Integer> array = new ArrayList<>();
            for (int i = minimum + 1; i <= maximum; i++){
                array.add(i);
            }
            return (ArrayList) array;
        }

    public void AllVertexCombinations(List<Integer> row, List<Integer> col, String description){
        int letterNum = 0;
        for (int i = 0; i < row.size(); i++){
            for (int a = 0; a < col.size(); a++){
                System.out.println(row.get(i) + col.get(a));
                Vertex newVertex = new Vertex(row.get(i), col.get(a));
                map.put(newVertex, description.charAt(letterNum));
                letterNum++;
            }
        }
    }

    public static Character[][] generateBoard(Map<Vertex,Character> finalMap){
        Character arr[][] = new Character[5][5];
        for (Map.Entry<Vertex,Character> entry : finalMap.entrySet()) {
           int x = entry.getKey().getX();
           int y = entry.getKey().getY();
           Character letter = entry.getValue();
           arr[x-1][y-1] = letter;
        }
        return arr;
    }

    public void checkVertexRepetition(Map<Vertex, Character> checkMap){
        int highest = 0;
        Character mostFrequentLetter = null;
        List<Character> sameVertexLetter = new ArrayList<>();

        for (Map.Entry<Vertex,Character> entry : checkMap.entrySet()){
            int count = 0;
            int x = entry.getKey().getX();
            int y = entry.getKey().getY();
            Character letter = entry.getValue();
            sameVertexLetter.add(letter);
            Vertex original = new Vertex(x, y);
            alreadyProcessedVertices.put(original.toString(), letter);

            if (alreadyProcessedVertices.containsKey(original.toString())) {
                continue;
            }
            else {
                for (Map.Entry<Vertex,Character> entryOne : checkMap.entrySet()){
                    int anotherX = entry.getKey().getX();
                    int anotherY = entry.getKey().getY();
                    Character anotherLetter = entry.getValue();
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

