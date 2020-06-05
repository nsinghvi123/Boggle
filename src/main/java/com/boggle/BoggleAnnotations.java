package com.boggle;

import com.google.cloud.vision.v1.EntityAnnotation;

import java.util.ArrayList;
import java.util.List;

public class BoggleAnnotations {
    EntityAnnotation entityAnnotation;
    // all these vertices are null: please change
    Vertex topLeft;
    Vertex topRight;
    Vertex bottomLeft;
    Vertex bottomRight;
    int widthActual;
    int heightActual;
    int rowPixelIncrement;
    int colPixelIncrement;
    String description;

    public static void main(String[] args) {
    }

    public BoggleAnnotations(EntityAnnotation newEntity, int width, int height, String description) {
        this.entityAnnotation = newEntity;
        widthActual = width;
        heightActual = height;
        rowPixelIncrement = widthActual / 5;
        colPixelIncrement = heightActual / 5;
        this.topLeft = new Vertex(entityAnnotation.getBoundingPoly().getVertices(0).getX(), entityAnnotation.getBoundingPoly().getVertices(0).getY());
        this.topRight = new Vertex(entityAnnotation.getBoundingPoly().getVertices(1).getX(), entityAnnotation.getBoundingPoly().getVertices(1).getY());
        this.bottomRight = new Vertex(entityAnnotation.getBoundingPoly().getVertices(2).getX(), entityAnnotation.getBoundingPoly().getVertices(2).getY());
        this.bottomLeft = new Vertex(entityAnnotation.getBoundingPoly().getVertices(3).getX(), entityAnnotation.getBoundingPoly().getVertices(3).getY());
        description.replaceAll("\\s+", "");
        this.description = description;
    }

    public int getBottomLeftX() {
        bottomLeft.x = entityAnnotation.getBoundingPoly().getVertices(3).getX();
        return bottomLeft.x;
    }

    public int getBottomLeftY() {
        bottomLeft.y = entityAnnotation.getBoundingPoly().getVertices(3).getY();
        return bottomLeft.y;
    }

    public int getBottomRightX() {
        bottomRight.x = entityAnnotation.getBoundingPoly().getVertices(2).getX();
        return bottomRight.x;
    }

    public int getBottomRightY() {
        bottomRight.y = entityAnnotation.getBoundingPoly().getVertices(2).getY();
        return bottomRight.y;
    }

    public int getTopRightX() {
        topRight.x = entityAnnotation.getBoundingPoly().getVertices(1).getX();
        return topRight.x;
    }

    public int getTopRightY() {
        topRight.y = entityAnnotation.getBoundingPoly().getVertices(1).getY();
        return topRight.y;
    }

    public int getTopLeftX() {
        topLeft.x = entityAnnotation.getBoundingPoly().getVertices(0).getX();
        return topLeft.x;
    }

    public int getTopLeftY() {
        topLeft.y = entityAnnotation.getBoundingPoly().getVertices(0).getY();
        return topLeft.y;
    }

    public int findClosestLineNumber(int coordinate, int pixelIncrement) {
        int pixelCoordinate = coordinate;
        int num = -1;
        double minDistance = Integer.MAX_VALUE;
        for (int a = 0; a <= 5; a++){
            int pixelCutoff = a * pixelIncrement;
            double distance = pixelCoordinate - pixelCutoff;
            distance = Math.abs(distance);
            if (distance < minDistance){
                minDistance = distance;
                num  = a;
            }
        }
    return num;
    }

}