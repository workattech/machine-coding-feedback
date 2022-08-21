package com.example.snakeLadder.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMsg {

    INVALID_SNAKE ("Snake head should be at high position wrt Snake tail"),
    PLAYER_ALREADY_EXISTS("A user having same already exist");

    private String msg;
}
