package chess;

import boardgame.Board;
import boardgame.Position;
import chess_pieces.King;
import chess_pieces.Rook;

public class ChessMatch {
    
    private Board board;
    
    public ChessMatch(){
        board = new Board(8, 8);
        InitialSetup();
    }

    public ChessPiece[][] getPieces(){
        
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getCollumns()];

        for(int i = 0; i < board.getRows();i++){
            for(int j = 0; j < board.getCollumns();j++){
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return mat;
    }

    private void InitialSetup(){
        board.place_piece(new Rook(board, Colors.WHITE), new Position(2, 1));
        board.place_piece(new King(board, Colors.BLACK), new Position(0, 4));
        board.place_piece(new King(board, Colors.WHITE), new Position(7, 4));
    }

}
