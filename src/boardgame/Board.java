package boardgame;

public class Board {
    private int rows;
    private int collumns;

    private Piece[][] pieces;
    
    public Board(int rows,int collumns){
        this.collumns = collumns;
        this.rows = rows;

        pieces = new Piece[rows][collumns];
    }

    public int getCollumns() {
        return collumns;
    }

    public int getRows() {
        return rows;
    }

    public void setCollumns(int collumns) {
        this.collumns = collumns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
