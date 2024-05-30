package boardgame;

public class Board {
    private int rows;
    private int collumns;

    private Piece[][] pieces;
    
    public Board(int rows,int collumns){

        if(rows < 1 || collumns < 1){
            throw new BoardException("tamanho inválido de tabuleiro");
        }

        this.collumns = collumns;
        this.rows = rows;

        pieces = new Piece[rows][collumns];
    }

    public Piece piece(int row, int collumn){

        if(!Position_exists(row,collumn)){
            throw new BoardException("posição não existe");
        }

        return piece(new Position(row, collumn));
    }

    public Piece piece(Position position){

        if(!Position_exists(position)){
            throw new BoardException("posição não existe");
        }

        return pieces[position.getRow()][position.getCollumn()];
    }

    public void place_piece(Piece piece, Position position){

        if(There_is_a_Piece(position)){
            throw new BoardException("tem uma peça aí: " + position);
        }

        pieces[position.getRow()][position.getCollumn()] = piece;
        piece.position = position;
    }

    private boolean Position_exists(int row, int collumn){
        return row >= 0 && row < rows && collumn >= 0 && collumn < collumns;
    }

    public boolean Position_exists(Position position){

        return Position_exists(position.getRow(), position.getCollumn());

    }

    public boolean There_is_a_Piece(Position position){

        if(!Position_exists(position)){
            throw new BoardException("posição não existe");
        }

        return piece(position) != null;
    }

    public int getCollumns() {
        return collumns;
    }

    public int getRows() {
        return rows;
    }
}
