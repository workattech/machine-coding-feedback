package com.hitesh.TicTacToe.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Command {

    private String name;
    private List<String> params;
    private static final String SPACE = " ";


    public Command(final String inputLine) {

        List<String> tokenList = Arrays.stream(inputLine.trim().split(SPACE))
                                    .map(String::trim)
                                    .filter(token -> token.length()>0)
                                    .collect(Collectors.toList());

        if(tokenList.isEmpty()){
            throw new RuntimeException("Invalid command");
        }

        name = tokenList.get(0);
        tokenList.remove(0);
        params = tokenList;
    }
}
