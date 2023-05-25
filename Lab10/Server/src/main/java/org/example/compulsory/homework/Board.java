package org.example.compulsory.homework;

public class Board {
    private Piece[][] pieces;

    public Board() {
        pieces = new Piece[15][15];
    }

    public void setPiece(int x, int y, Piece piece) {
        pieces[x][y] = piece;
    }

    public Character getPieceChar(int x, int y) {
        if (pieces[x][y] == null) {
            return ' ';
        } else {
            return pieces[x][y] == Piece.WHITE ? 'w' : 'B';
        }
    }

}
