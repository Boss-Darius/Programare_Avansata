package org.example.compulsory.homework;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player turn;
    private String code;

    private boolean isOver;
    private boolean isWon;
    private boolean isStarted;

    private long blitzTime;

    public Game(String code,Player author,long blitzTime){
        board=new Board();
        this.code=code;
        player1=author;
        turn=author;
        isOver=true;
        isStarted=false;
        isWon=false;
        this.blitzTime=blitzTime;

    }

    public void start(){
        isStarted=true;
    }
}
