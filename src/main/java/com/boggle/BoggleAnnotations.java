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
        return this.bottomLeft.x;
    }

    public int getBottomLeftY() {
        return this.bottomLeft.y;
    }

    public int getBottomRightX() {
        return this.bottomRight.x;
    }

    public int getBottomRightY() {
        return this.bottomRight.y;
    }

    public int getTopRightX() {
        return this.topRight.x;
    }

    public int getTopRightY() {
        return this.topRight.y;
    }

    public int getTopLeftX() {
        return this.topLeft.x;
    }

    public int getTopLeftY() {
        return this.topLeft.y;
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