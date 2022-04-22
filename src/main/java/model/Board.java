package model;

import java.util.List;

public class Board {
    private List<Piece> whitePieces;
    private List<Piece> blackPieces;

    public Board() {
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public void setWhitePieces(List<Piece> whitePieces) {
        this.whitePieces = whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public void setBlackPieces(List<Piece> blackPieces) {
        this.blackPieces = blackPieces;
    }
}
