package org.example;

import Map.Matrix;
import Resources.Resource;
import Robots.Robot;
import TimeKeeper.TimeKeeperThread;

/**
 * Hello world!
 */
public class App {
    public static int[] initializeRobotStartingPoint(int n){
        int [] coordonates=new int[4];
        for(int i=0;i<4;i++){
            coordonates[i]=(int)(Math.random()*100)%n;
        }

        while( coordonates[0]!=coordonates[2] && coordonates[1]!=coordonates[3]){
            for(int i=0;i<4;i++){
                coordonates[i]=(int)(Math.random()*100)%n;
            }
        }

        return coordonates;
    }
    public static void main(String[] args) {

        int [] coordonates=new int[4];
        coordonates=initializeRobotStartingPoint(3);
        Matrix map=new Matrix(3);
        Resource resource=new Resource(3);
        Robot mo=new Robot("Mo",map,resource, coordonates[0],coordonates[1]);
        Robot foca=new Robot("Foca",map,resource,coordonates[2],coordonates[3]);

        Thread timer=new Thread(new TimeKeeperThread(5));
        timer.setDaemon(true);
        timer.start();
        System.out.println(mo);
        System.out.println(foca);
        mo.start();
        foca.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("Sleep didn't work");
        }
    }
}
