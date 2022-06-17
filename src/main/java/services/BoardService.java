package services;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private Board board;
    private PrinterService printerService;

    public BoardService(Board board, PrinterService printerService) {
        this.board = board;
        this.printerService = printerService;
    }

    public void initiliazeWhitePieces() {
        List<Piece> whitePieces = new ArrayList<>();
        /*
        Initiliaze Pawn
         */
        for (int col = 1; col <= 8; col++) {
            whitePieces.add(new Pawn(PlayerColour.WHITE, 20 + col, "WP"));
        }
        /*
        Initiliaze Rook
         */
        whitePieces.add(new Rook(PlayerColour.WHITE, 11, "WR"));
        whitePieces.add(new Rook(PlayerColour.WHITE, 18, "WR"));

        /*
        Initiliaze Knight
         */
        whitePieces.add(new Knight(PlayerColour.WHITE, 12, "WN"));
        whitePieces.add(new Knight(PlayerColour.WHITE, 17, "WN"));

        /*
        Initiliaze Bishop
         */
        whitePieces.add(new Bishop(PlayerColour.WHITE, 13, "WB"));
        whitePieces.add(new Bishop(PlayerColour.WHITE, 16, "WB"));

        /*
        Initiliaze Queen
         */
        whitePieces.add(new Queen(PlayerColour.WHITE, 14, "WQ"));
        /*
        Initiliaze King
         */
        whitePieces.add(new King(PlayerColour.WHITE, 15, "WK"));

        board.setWhitePieces(whitePieces);
    }

    ;

    public void initiliazeBlackPieces() {
        List<Piece> blackPieces = new ArrayList<>();
        /*
        Initiliaze Pawn
         */
        for (int col = 1; col <= 8; col++) {
            blackPieces.add(new Pawn(PlayerColour.BLACK, 70 + col, "BP"));
        }
        /*
        Initiliaze Rook
         */
        blackPieces.add(new Rook(PlayerColour.BLACK, 81, "BR"));
        blackPieces.add(new Rook(PlayerColour.BLACK, 88, "BR"));

        /*
        Initiliaze Knight
         */
        blackPieces.add(new Knight(PlayerColour.BLACK, 82, "BN"));
        blackPieces.add(new Knight(PlayerColour.BLACK, 87, "BN"));

        /*
        Initiliaze Bishop
         */
        blackPieces.add(new Bishop(PlayerColour.BLACK, 83, "BB"));
        blackPieces.add(new Bishop(PlayerColour.BLACK, 86, "BB"));

        /*
        Initiliaze Queen
         */
        blackPieces.add(new Queen(PlayerColour.BLACK, 84, "BQ"));

        /*
        Initiliaze King
         */
        blackPieces.add(new King(PlayerColour.BLACK, 85, "BK"));

        board.setBlackPieces(blackPieces);

    }

    ;

    public Piece getPieceAtPosition(String pos) {

        int position = getTransformedCoordinate(pos);
        for (Piece piece : board.getWhitePieces()) {
            if (piece.getCurrentPos() == position) {
                return piece;
            }
        }
        for (Piece piece : board.getBlackPieces()) {
            if (piece.getCurrentPos() == position) {
                return piece;
            }
        }

        return null;
    }

    protected void removePiece(Piece piece, PlayerColour playerColour) {
        List<Piece> piecesList;
        if (playerColour == PlayerColour.BLACK) piecesList = board.getWhitePieces();
        else piecesList = board.getBlackPieces();
        piecesList.remove(piece);
    }

    public boolean move(String startPos, String endPos, PlayerColour playerColour) {

        Piece pieceAtStartPos = getPieceAtPosition(startPos);
        Piece pieceAtEndPos = getPieceAtPosition(endPos);
        Boolean canKillOpponentAtEndingPosition = false;
        if(pieceAtStartPos==null) return false;
        if (pieceAtEndPos != null)
            canKillOpponentAtEndingPosition = pieceAtStartPos.getPlayerColour() != pieceAtEndPos.getPlayerColour();

        List<Integer> path;
        int endingPosition = getTransformedCoordinate(endPos);
        if (pieceAtStartPos.getPlayerColour() != playerColour) {
            return false;
        }

        path = pieceAtStartPos.getPath(endPos, canKillOpponentAtEndingPosition);

        if (path.isEmpty() || !path.contains(endingPosition)) {
            return false;
        }
        path.remove(Integer.valueOf(endingPosition));

        if (!validatePath(path)) {
            return false;
        }

        if (pieceAtEndPos != null && pieceAtEndPos.getPlayerColour() == playerColour) {
            return false;
        } else if (pieceAtEndPos != null && pieceAtEndPos.getPlayerColour() != playerColour) {
            removePiece(pieceAtEndPos, playerColour);
        }
        pieceAtStartPos.setCurrentPos(endingPosition);
        return true;
    }

    public boolean validatePath(List<Integer> path) {
        for (Piece piece : board.getWhitePieces()) {
            if (path.contains(piece.getCurrentPos())) return false;
        }
        for (Piece piece : board.getBlackPieces()) {
            if (path.contains(piece.getCurrentPos())) return false;
        }
        return true;
    }

    public static int getTransformedCoordinate(String position) {
        int row = ((int) position.charAt(1) - (int) '0');
        int col = ((int) position.charAt(0) - (int) 'a') + 1;
        return (row * 10) + col;

    }


}
