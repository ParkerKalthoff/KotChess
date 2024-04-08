package kotchess.pieces;
import kotchess.board;

public class king extends abstractPiece{

    private boolean castleKingSide;
    private boolean castleQueenSide;

    public king(String color) {
        super(color, "King");
        this.castleKingSide = true;
        this.castleQueenSide = true;
    }

    public king(String color, Boolean castleKingSide, Boolean castleQueenSide) {
        super(color, "King");
        this.castleKingSide = castleKingSide;
        this.castleQueenSide = castleQueenSide;
    }

    @Override
    public int[] moves(board board) {
        return null;
    }

}
