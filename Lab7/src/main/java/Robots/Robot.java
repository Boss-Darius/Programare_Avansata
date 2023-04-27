package Robots;

import Map.Matrix;
import Resources.Resource;

import java.util.Arrays;

public class Robot extends Thread {
    private int x;
    private int y;
    private String name;

    private Matrix map;

    private int numberOfVisitedCells;

    private Resource resource;
    private int visitedCells;

    public Robot(String name, Matrix matrix, Resource resource,int xpos,int ypos) {
        this.name = name;
        map = matrix;
        this.resource = resource;
        x = xpos;
        y = ypos;
        visitedCells=0;
        incrementCells();
        map.getToCell(x, y,getTokensFromResource());
    }
    public void incrementCells(){
        numberOfVisitedCells++;
    }

    public int [] getTokensFromResource(){
        int numberOfTokens=resource.getDimension();
        int [] source=new int [numberOfTokens*numberOfTokens*numberOfTokens];
        int [] tokens=new int[numberOfTokens];

        for (int i = 0; i < numberOfTokens; i++) {
            tokens[i]=source[(int)(Math.random()*100)%(numberOfTokens*numberOfTokens*numberOfTokens)];
        }

        return tokens;
    }

    public void moveRight() {
        if (y < map.getDimension() - 1) {
            map.getToCell(x, y + 1,getTokensFromResource());
            incrementCells();
            map.moveFromCell(x, y);
            y = y + 1;
            System.out.println(this);
        }
        else {
            System.out.println(name + " can't move to the right");
        }
    }

    public void moveLeft() {
        if (y > 0) {
            map.getToCell(x, y - 1,getTokensFromResource());
            incrementCells();
            map.moveFromCell(x, y);
            y = y - 1;
            System.out.println(this);
        }
        else{
            System.out.println(name + " can't move to the left");
        }
    }

    public void moveUp() {
        if (x >0) {
            map.getToCell(x - 1, y,getTokensFromResource());
            incrementCells();
            map.moveFromCell(x, y);
            x = x - 1;
            System.out.println(this);
        }
        else {
            System.out.println(name + " can't move upwards");
        }
    }

    public void moveDown() {
        if (x < map.getDimension() - 1) {
            map.getToCell(x + 1, y,getTokensFromResource());
            incrementCells();
            map.moveFromCell(x, y);
            x = x + 1;
            System.out.println(this);
        }
        else {
            System.out.println(name + " can't move downwards");
        }
    }

    public void moveLowerRight() {
        if (y < map.getDimension() - 1 && x < map.getDimension() - 1) {
            map.getToCell(x + 1, y + 1,getTokensFromResource());
            incrementCells();
            map.moveFromCell(x, y);
            y = y + 1;
            x = x + 1;
            System.out.println(this);
        }
        else{
            System.out.println(name + " can't move lower-right");
        }
    }

    public void moveUperRight() {
        if (y < map.getDimension() - 1 && x > 0) {
            map.getToCell(x - 1, y + 1,getTokensFromResource());
            incrementCells();
            map.moveFromCell(x, y);
            y = y + 1;
            x = x - 1;
            System.out.println(this);
        }
        else{
            System.out.println(name + " can't move uper-right");
        }
    }

    public void moveLowerLeft() {
        if (y > 0 && x < map.getDimension() - 1) {
            map.getToCell(x + 1, y - 1,getTokensFromResource());
            incrementCells();
            map.moveFromCell(x, y);
            y = y - 1;
            x = x + 1;
            System.out.println(this);
        }
        else{
            System.out.println(name + " can't move lower-left");
        }
    }

    public void moveUperLeft() {
        if (y > 0 && x > 0) {
            map.getToCell(x - 1, y - 1,getTokensFromResource());
            incrementCells();
            map.moveFromCell(x, y);
            y = y - 1;
            x = x - 1;
            System.out.println(this);
        }
        else{
            System.out.println(name + " can't move upper-left");
        }
    }

    public void randomMove() {
        int decision = (int) (Math.random() * 100);
        decision=decision%8;

        switch (decision) {
            case 0: {
                moveRight();
                break;
            }
            case 1: {
                moveLeft();
                break;
            }
            case 2: {
                moveUp();
                break;
            }

            case 3: {
                moveDown();
                break;
            }
            case 4: {
                moveLowerRight();
                break;
            }

            case 5: {
                moveUperRight();
                break;
            }
            case 6: {
                moveUperLeft();
                break;
            }
            case 7: {
                moveLowerLeft();
                break;
            }
            default:{
                System.out.println(name +" is stuck");
            }
        }
    }

    public int getNumberOfVisitedCells() {
        return numberOfVisitedCells;
    }

    public void pauseFor(int n){
        System.out.println(name+" is paused for "+(double)(n/1000)+" seconds");
        try {
            wait(2000);
        } catch (InterruptedException e) {
            System.err.println("Eroare la wait din pauseFor()!");
        }
    }

    public void run(){
        while(map.getUnexplored()!=0){
            randomMove();
        }

        System.out.println(name +" visited "+getNumberOfVisitedCells()+" cells");
        System.out.println(name +" has inserted "+getNumberOfVisitedCells()*resource.getDimension()+" tokens");
    }

    @Override
    public String toString() {
        if (name.equals("Mo")) {
            return "Focă! vezi c-am ajuns până la celula [ " + x + " ][ " + y + " ]!";
        }
        if (name.equals("Foca")) {
            return "Mo! Eu sunt la celula [ " + x + " ][ " + y + " ]!";
        }

        return name + " the robot has reached the cell [ " + x + " ][ " + y + " ]";
    }
}
