package application;


import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        ChessMatch chessmatch = new ChessMatch();


        while(true){

            UI.PrintBoard(chessmatch.getPieces());

            System.out.println("");

            System.out.println("Print Source: ");
            ChessPosition source = UI.readChessPosition(sc);

            System.out.println("Target: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessmatch.PerformChessMove(source,target);
        }   

    }
}
