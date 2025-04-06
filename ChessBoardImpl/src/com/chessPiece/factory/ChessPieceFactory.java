package com.chessPiece.factory;

import com.chessPiece.BishopChessPiece;
import com.chessPiece.KingChessPiece;
import com.chessPiece.KnightChessPiece;
import com.chessPiece.NoChessPiece;
import com.chessPiece.PawnChessPiece;
import com.chessPiece.QueenChessPiece;
import com.chessPiece.RookChessPiece;
import com.chessPiece.interfaces.IChessPiece;
import com.chessPiece.interfaces.IChessPieceFactory;
import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;

public class ChessPieceFactory implements IChessPieceFactory {

	@Override
	public IChessPiece createChessPiece(ChessPieceType chessPieceType, ChessPieceColor chessPieceColor) {
		switch (chessPieceType) {
		case PAWN:
			return new PawnChessPiece(chessPieceColor);
		case QUEEN:
			return new QueenChessPiece(chessPieceColor);
		case KING:
			return new KingChessPiece(chessPieceColor);
		case ROOK:
			return new RookChessPiece(chessPieceColor);
		case BISHOP:
			return new BishopChessPiece(chessPieceColor);
		case KNIGHT:
			return new KnightChessPiece(chessPieceColor);
		case NONE:
		default:
			return new NoChessPiece();
		
		}
	}

}
