package services;

import model.Board;
import model.Piece;
import model.PlayerColour;

import java.util.List;

public class BoardService {
    private Board board;
    private PrinterService printerService;

    public BoardService(Board board, PrinterService printerService) {
        this.board = board;
        this.printerService = printerService;
    }
    public void IntiliazeWhitePieces() {};
    public void IntiliazeBlackPieces() {};

    public Piece getPieceAtPosition(String pos) {

            int position = getTransformedCoordinate(pos);

            for(Piece piece:board.getWhitePieces()) {
                if(piece.getCurrentPos() == position) return piece;
            }
            for(Piece piece:board.getBlackPieces()) {
                if(piece.getCurrentPos() == position) return piece;
            }

            return null;
    }

    protected void removePiece(Piece piece,PlayerColour playerColour) {
        List<Piece> piecesList;
        if(playerColour == PlayerColour.BLACK) piecesList = board.getWhitePieces();
        else piecesList = board.getBlackPieces();
        piecesList.remove(piece);
    }
    public boolean move(String startPos, String endPos, PlayerColour playerColour) {
        Piece pieceAtStartPos = getPieceAtPosition(startPos);
        List<Integer>path;
        int endingPosition = getTransformedCoordinate(endPos);
        if(pieceAtStartPos!=null && pieceAtStartPos.getPlayerColour() == playerColour) {

            path = pieceAtStartPos.getPath(endPos);

            if(path.isEmpty() || !path.contains(endingPosition)) return false;
            path.remove(endingPosition);

            if(!validatePath(path))
                return false;
        }
        Piece pieceAtEndPos = getPieceAtPosition(endPos);
        if(pieceAtEndPos!=null && pieceAtEndPos.getPlayerColour() == playerColour)return false;
        else if(pieceAtEndPos!=null && pieceAtEndPos.getPlayerColour() != playerColour) {
            removePiece(pieceAtEndPos,playerColour);
        }
        return true;
    }

    public  boolean validatePath(List<Integer> path){
        for(Piece piece:board.getWhitePieces()) {
            if(path.contains(piece.getCurrentPos())) return false;
        }
        for(Piece piece:board.getBlackPieces()) {
            if(path.contains(piece.getCurrentPos())) return false;
        }
        return  true;
    }

    public static int getTransformedCoordinate(String position) {
        int row   = ((int)position.charAt(0)-(int)'a')+1;
        int col   = ((int)position.charAt(1)-(int)'0');
        return (row*10)+col;

    }


}
