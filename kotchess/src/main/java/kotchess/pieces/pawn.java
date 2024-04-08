package kotchess.pieces;
import kotchess.board;

public class pawn extends abstractPiece{

    public pawn(String color) {
        super(color, "Pawn");
    }

    @Override
    public int[] moves(board board) {
        return null;
    }
}
