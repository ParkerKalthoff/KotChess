package kotchess;
import kotchess.pieces.*;

public class factory {

    private String placementString;
    private String activeColorString;
    private String castlingRightsString;
    private String enpassantSquareString;
    private int halfmoveClock;
    private int fullmoveCount;

    
    private void fenStringToClassVariables(String fenString){
        String splitFenString[] = fenString.split("\\s+");
        this.placementString = splitFenString[0].replaceAll(String.valueOf('/'), ""); // Removes the /'s
        this.activeColorString = splitFenString[1];
        this.castlingRightsString = splitFenString[2];
        this.enpassantSquareString = splitFenString[3];
        this.halfmoveClock = Integer.parseInt(splitFenString[4]);
        this.fullmoveCount = Integer.parseInt(splitFenString[5]);
    }

    private boolean isCharNumber(char c){
        return c >= '0' && c <= '9';
    }

    private abstractPiece pieceFactory(char symbol, boolean Q, boolean K, boolean q, boolean k){

        String color = (Character.toUpperCase(symbol) == symbol) ? "White" : "Black";
        char piece = Character.toUpperCase(symbol);

        switch (piece) {
            case 'P':
                return new pawn(color);
            case 'B':
                return new bishop(color);
            case 'N':
                return new knight(color);
            case 'R':
                return new rook(color);
            case 'Q':
                return new queen(color);
            case 'K':
                boolean queensideCastle = (color.equals("White")) ? Q : q; // Sets Queenside castling boolean
                boolean kingsideCastle = (color.equals("White")) ? K : k; // Sets Kingside castling bool
                return new king(color, kingsideCastle, queensideCastle);
            default:
                throw new IllegalArgumentException();
        }
    }

    private abstractPiece[] placementStringToBoardspace(String placementString, String castlingRightsString){

        boolean Q = castlingRightsString.contains("Q");
        boolean K = castlingRightsString.contains("K");
        boolean q = castlingRightsString.contains("q");
        boolean k = castlingRightsString.contains("k");

        abstractPiece boardSpace[] = new abstractPiece[64];
        char placementArray[] = placementString.toCharArray();

        int boardIndex = 0;

        // using placementArrayIndex to iterate over placementArray, boardIndex to to set boardspace indecies
        for(int placementArrayIndex = 0; placementArrayIndex < placementArray.length; placementArrayIndex++){
            if(isCharNumber(placementArray[placementArrayIndex])){
                boardSpace[boardIndex] = pieceFactory(placementArray[placementArrayIndex], Q, K, q, k);
                boardIndex++;
            } else {
                boardIndex += (int) placementArray[placementArrayIndex];
            }
        }

        return boardSpace;
    }

    public int chessIndexToNumber(String chessIndex) {
        if(chessIndex.length() == 1) return -1;
        int column = chessIndex.charAt(0) - 'a';
        int row = Character.getNumericValue(chessIndex.charAt(1)) - 1;
        return row * 8 + column;
    }

    public board createBoard(String fenString){
        fenStringToClassVariables(fenString);
        abstractPiece boardspace[] = placementStringToBoardspace(this.placementString, this.castlingRightsString);
        String activeColor = (activeColorString.equals("w")) ? "White" : "Black";
        int enpassantSquare =  chessIndexToNumber(enpassantSquareString);
        return new board(boardspace, activeColor, enpassantSquare, halfmoveClock, fullmoveCount);
    }
}
