package application;


import chess.ChessMatch;

public class App {
    public static void main(String[] args) throws Exception {

        ChessMatch chessmatch = new ChessMatch();

        UI.PrintBoard(chessmatch.getPieces());

    }
}
