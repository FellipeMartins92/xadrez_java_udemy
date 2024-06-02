package application;


import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        ChessMatch chessmatch = new ChessMatch();


        while(true){

            try{
                UI.ClearScreen();

                UI.PrintMatch(chessmatch);

                System.out.println("");

                System.out.println("Print Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] PossibleMoves = chessmatch.PossibleMoves(source);
                UI.ClearScreen();
                UI.PrintBoard(chessmatch.getPieces(), PossibleMoves);

                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessmatch.PerformChessMove(source,target);
            }catch(ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }   

    }
}
