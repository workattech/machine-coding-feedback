package com.chessPiece.interfaces;

import com.enums.ChessPieceColor;
import com.enums.ChessPieceType;

public interface IChessPieceFactory {
	IChessPiece createChessPiece(ChessPieceType chessPieceType, ChessPieceColor chessPieceColor);
}
