package kotchess;
import kotchess.pieces.*;

public class board {

    private abstractPiece boardSpace[];
    private String activeColor;
    private int enpassantSquare;
    private int halfmoveClock;
    private int fullmoveCount;

    private int whiteScore;
    private int blackScore;

    public board(abstractPiece[] boardSpace, String activeColor, int enpassantSquare, int halfmoveClock, int fullmoveCount) {
        this.boardSpace = boardSpace;
        this.activeColor = activeColor;
        this.enpassantSquare = enpassantSquare;
        this.halfmoveClock = halfmoveClock;
        this.fullmoveCount = fullmoveCount;
    }

    private void refreshBoard(){

        // Set score, it adds the king 999 score, this is for planned future engine
        this.whiteScore = 0;
        this.blackScore = 0;

        for(int i = 0; i < 64; i++){
            if(boardSpace[i] == null){ continue; } // ignore empty square

            if(boardSpace[i].getColor().equals("White")){
                this.whiteScore += boardSpace[i].getValue();
            } else {
                this.blackScore += boardSpace[i].getValue();
            }
        }

        updateTurnVariables();
    }

    public int getEnpassantSquare(){
        return this.enpassantSquare;
    }

    public void setEnpassantSquare(int enpassantSquare){
        if(enpassantSquare > 63) throw new IllegalArgumentException();
        this.enpassantSquare = enpassantSquare;
    }

    public int getTurnNumber(){
        return this.fullmoveCount;
    }

    public String getActiveColor(){
        return this.activeColor;
    }

    private void updateTurnVariables(){
        this.fullmoveCount += 1;
        this.activeColor = this.activeColor.equals("White") ? "Black" : "White";
    }

    public int getWhiteScore(){
        return this.whiteScore - 999;
    }

    public int getBlackScore(){
        return this.blackScore - 999;
    }

    public int getScore(){
        return getWhiteScore() - getBlackScore();
    }
}
