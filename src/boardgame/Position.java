package boardgame;

public class Position {
    private int row;
    private int collumn;

    public Position(int row, int collumn){
        this.collumn = collumn;
        this.row = row;
    }

    public void setCollumn(int collumn) {
        this.collumn = collumn;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCollumn() {
        return collumn;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString(){
        return row + ", " + collumn;
    }
}
