package chess_pieces;

import boardgame.Board;
import boardgame.Position;
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

    private boolean canmove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] PossibleMoves() {
       boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()];

        Position p = new Position(0, 0);

        //acima
        p.setValues(position.getRow() - 1, position.getCollumn());
        if(getBoard().Position_exists(p) && canmove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }

        // abaixo
        p.setValues(position.getRow() + 1, position.getCollumn());
        if(getBoard().Position_exists(p) && canmove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }

         // esquerda
         p.setValues(position.getRow(), position.getCollumn() - 1);
         if(getBoard().Position_exists(p) && canmove(p)){
             mat[p.getRow()][p.getCollumn()] = true;
         }

          // direita
        p.setValues(position.getRow(), position.getCollumn() + 1);
        if(getBoard().Position_exists(p) && canmove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //cima-direita
        p.setValues(position.getRow() - 1, position.getCollumn() + 1);
        if(getBoard().Position_exists(p) && canmove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //cima-esquerda
        p.setValues(position.getRow() - 1, position.getCollumn() - 1);
        if(getBoard().Position_exists(p) && canmove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }

        //baixo-esquerda
        p.setValues(position.getRow() + 1, position.getCollumn() - 1);
        if(getBoard().Position_exists(p) && canmove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }

         //baixo-direita
         p.setValues(position.getRow() + 1, position.getCollumn() + 1);
         if(getBoard().Position_exists(p) && canmove(p)){
             mat[p.getRow()][p.getCollumn()] = true;
         }



       return mat;
    }

}
