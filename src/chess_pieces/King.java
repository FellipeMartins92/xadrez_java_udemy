package chess_pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Colors;

public class King extends ChessPiece{

    public King(Board board, Colors color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }

}
