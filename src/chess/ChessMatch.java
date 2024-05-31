package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess_pieces.King;
import chess_pieces.Rook;
import javafx.geometry.Pos;

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

    private void place_new_piece(char collumn, int row, ChessPiece piece){
        board.place_piece(piece, new ChessPosition(collumn, row).toPosition());
    }

    private void InitialSetup(){
        place_new_piece('c', 1, new Rook(board, Colors.WHITE));
        place_new_piece('c', 2, new Rook(board, Colors.WHITE));
        place_new_piece('d', 2, new Rook(board, Colors.WHITE));
        place_new_piece('e', 2, new Rook(board, Colors.WHITE));
        place_new_piece('e', 1, new Rook(board, Colors.WHITE));
        place_new_piece('d', 1, new King(board, Colors.WHITE));

        place_new_piece('c', 7, new Rook(board, Colors.BLACK));
        place_new_piece('c', 8, new Rook(board, Colors.BLACK));
        place_new_piece('d', 7, new Rook(board, Colors.BLACK));
        place_new_piece('e', 7, new Rook(board, Colors.BLACK));
        place_new_piece('e', 8, new Rook(board, Colors.BLACK));
        place_new_piece('d', 8, new King(board, Colors.BLACK));
    }

    public ChessPiece PerformChessMove(ChessPosition SourcePosition,ChessPosition TargetPosition){

        Position source = SourcePosition.toPosition();
        Position target = TargetPosition.toPosition();

        validateSourcePosition(source);
        validateTargetPosition(source,target);
        Piece CapturedPiece = MakeMove(source,target);

        return (ChessPiece) CapturedPiece;
    }

    private Piece MakeMove(Position Source,Position Target){
        Piece p = board.Remove_piece(Source);
        Piece captured = board.Remove_piece(Target);
        board.place_piece(p, Target);

        return captured;
    }

    private void validateSourcePosition(Position position){
        if(!board.There_is_a_Piece(position)){
            throw new ChessException("não tem peça aí");
        }

        if(!board.piece(position).IsThereAnyPossibleMove()){
            throw new ChessException("não tem como mover essa peça aí");
        }

    }

    private void validateTargetPosition(Position source, Position Target){
        if(!board.piece(source).PossibleMove(Target)){
            throw new ChessException("peça escolhida não pode ir aí");
        }
    }

}
