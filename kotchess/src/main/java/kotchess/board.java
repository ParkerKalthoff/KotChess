package kotchess;
import kotchess.pieces.*;

public class board {

    private abstractPiece boardSpace[];
    private String activeColor;
    private int enpassantSquare;
    private int halfmoveClock;
    private int fullmoveCount;

    public board(abstractPiece[] boardSpace, String activeColor, int enpassantSquare, int halfmoveClock, int fullmoveCount) {
        this.boardSpace = boardSpace;
        this.activeColor = activeColor;
        this.enpassantSquare = enpassantSquare;
        this.halfmoveClock = halfmoveClock;
        this.fullmoveCount = fullmoveCount;
    }
}
