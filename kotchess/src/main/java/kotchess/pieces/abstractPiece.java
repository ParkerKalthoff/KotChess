package kotchess.pieces;
import kotchess.board;

public abstract class abstractPiece {

    public abstractPiece(String color, String name){
        setColor(color);
        setName(name);
        setValue();
        setSymbol();
        setPinned(false);
    }

    private String color;
    private String name;
    private int value;
    private char symbol;
    private boolean pinned;



    abstract int[] moves(board board);



    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        if(color == "White" || color == "Black"){
            this.color = color;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){

        if( name.equals("Pawn") ||
            name.equals("Bishop") ||
            name.equals("Knight") ||
            name.equals("Rook") ||
            name.equals("Queen") ||
            name.equals("King")
        ) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol() {

        String name = this.getName();
        String color = this.getColor();

        switch(name) {
            case "Pawn":
                this.symbol = (color.equals("White")) ? 'P' : 'p';
                break;
            case "Bishop":
                this.symbol = (color.equals("White")) ? 'B' : 'b';
                break;
            case "Knight":
                this.symbol = (color.equals("White")) ? 'N' : 'n';
                break;
            case "Rook":
                this.symbol = (color.equals("White")) ? 'R' : 'r';
                break;
            case "Queen":
                this.symbol = (color.equals("White")) ? 'Q' : 'q';
                break;
            case "King":
                this.symbol = (color.equals("White")) ? 'k' : 'k';
                break;
            default:
                throw new RuntimeException();
          }
    }

    public int getValue() {
        return this.value;
    }

    public void setValue() {

        String name = this.getName();

        switch(name) {
            case "Pawn":
                this.value = 1;
                break;
            case "Bishop":
                this.value = 3;
                break;
            case "Knight":
                this.value = 3;
                break;
            case "Rook":
                this.value = 5;
                break;
            case "Queen":
                this.value = 9;
                break;
            case "King":
                this.value = 999;
                break;
            default:
                throw new IllegalArgumentException();
          }
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
