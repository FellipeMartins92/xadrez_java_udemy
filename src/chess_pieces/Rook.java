package chess_pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Colors;

public class Rook extends ChessPiece{

    public Rook(Board board, Colors color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
	public boolean[][] PossibleMoves() {
        
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()];
		
		Position p = new Position(0, 0);
		
		// above
		p.setValues(position.getRow() - 1, position.getCollumn());
		while (getBoard().Position_exists(p) && !getBoard().There_is_a_Piece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().Position_exists(p) && IsThereAnyOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		// left
		p.setValues(position.getRow(), position.getCollumn() - 1);
		while (getBoard().Position_exists(p) && !getBoard().There_is_a_Piece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setCollumn(p.getCollumn() - 1);
		}
		if (getBoard().Position_exists(p) && IsThereAnyOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		// right
		p.setValues(position.getRow(), position.getCollumn() + 1);
		while (getBoard().Position_exists(p) && !getBoard().There_is_a_Piece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setCollumn(p.getCollumn() + 1);
		}
		if (getBoard().Position_exists(p) && IsThereAnyOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		// below
		p.setValues(position.getRow() + 1, position.getCollumn());
		while (getBoard().Position_exists(p) && !getBoard().There_is_a_Piece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().Position_exists(p) && IsThereAnyOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		return mat;
	}

}
