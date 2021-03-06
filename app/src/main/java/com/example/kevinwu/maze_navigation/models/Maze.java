package com.example.kevinwu.maze_navigation.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kevin on 2/10/2017.
 */

public class Maze implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;

    private boolean[][] verticalLines;
    private boolean[][] horizontalLines;
    private boolean[][] verticalDoors;
    private boolean[][] horizontalDoors;
    private int sizeX, sizeY;         //stores the width and height of the maze
    private int currentX, currentY;   //stores the current location of the ball
    private int finalX, finalY;       //stores the finishing of the maze
    private boolean gameComplete;
    private ArrayList<Pair> links;
    private int mazeNum;
    private int startX;
    private int startY;

    public int getMazeWidth() {
        return sizeX;
    }
    public int getMazeHeight() {
        return sizeY;
    }

    public boolean move(int direction) {
        boolean moved = false;
        if(direction == UP) {
            if(currentY != 0 && !horizontalLines[currentY-1][currentX] && !horizontalDoors[currentY-1][currentX]) {
                currentY--;
                moved = true;
            }
        }
        if(direction == DOWN) {
            if(currentY != sizeY-1 && !horizontalLines[currentY][currentX] && !horizontalDoors[currentY][currentX]) {
                currentY++;
                moved = true;
            }
        }
        if(direction == RIGHT) {
            if(currentX != sizeX-1 && !verticalLines[currentY][currentX] && !verticalDoors[currentY][currentX]) {
                currentX++;
                moved = true;
            }
        }
        if(direction == LEFT) {
            if(currentX != 0 && !verticalLines[currentY][currentX-1] && !verticalDoors[currentY][currentX-1]) {
                currentX--;
                moved = true;
            }
        }
        if(moved) {
            if(currentX == finalX && currentY == finalY) {
                gameComplete = true;
            }
        }
        return moved;
    }

    public boolean isGameComplete() {
        return gameComplete;
    }
    public void setStartPosition(int x, int y) {
        startX = x;
        startY = y;
        currentX = x;
        currentY = y;
    }
    public int getFinalX() {
        return finalX;
    }
    public int getFinalY() {
        return finalY;
    }
    public void setFinalPosition(int x, int y) {
        finalX = x;
        finalY = y;
    }
    public void resetPosition() {
        currentX = startX;
        currentY = startY;
    }
    public int getCurrentX() {
        return currentX;
    }
    public int getCurrentY() {
        return currentY;
    }
    public boolean[][] getHorizontalLines() {
        return horizontalLines;
    }
    public void setHorizontalLines(boolean[][] lines) {
        horizontalLines = lines;
        sizeX = horizontalLines[0].length;
    }
    public boolean[][] getVerticalLines() {
        return verticalLines;
    }
    public void setVerticalLines(boolean[][] lines) {
        verticalLines = lines;
        sizeY = verticalLines.length;
    }

    public boolean[][] getVerticalDoors() { return verticalDoors; }
    public void setVerticalDoors(boolean[][] doors) {
        verticalDoors = doors;
    }

    public boolean[][] getHorizontalDoors() { return horizontalDoors; }
    public void setHorizontalDoors(boolean[][] doors) {
        horizontalDoors = doors;
    }

    public boolean isWall(String orientation, int x, int y) {
        if (orientation.equals("Vertical")) {
            if (verticalLines[x][y])
                return true;
        }
        else if (orientation.equals("Horizontal")) {
            if (horizontalLines[x][y])
                return true;
        }
        return false;
    }

    public void bombWalls(String orientation, int x, int y) {
        if (orientation.equals("Vertical")) {
            verticalLines[x][y] = false;
        }
        else if (orientation.equals("Horizontal")) {
            horizontalLines[x][y] = false;
        }
    }

    public boolean isDoor(String orientation, int x, int y) {
        if (orientation.equals("Vertical")) {
            if (verticalDoors[x][y])
                return true;
        }
        else if (orientation.equals("Horizontal")) {
            if (horizontalDoors[x][y])
                return true;
        }
        return false;
    }

    public void openDoors(String orientation, int x, int y) {
        if (orientation.equals("Vertical")) {
            verticalDoors[x][y] = false;
        }
        else if (orientation.equals("Horizontal")) {
            horizontalDoors[x][y] = false;
        }
    }

    public ArrayList<Pair> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Pair> links) {
        this.links = links;
    }
    public void setMazeNum(int x) {
        mazeNum = x;
    }
    public int getMazeNum() {
        return mazeNum;
    }
}
