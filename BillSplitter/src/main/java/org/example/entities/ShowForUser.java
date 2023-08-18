package org.example.entities;

public class ShowForUser implements CommandProcessor{
    @Override
    public void process(String Command, UserBase userBase) {

        userBase.printBalance(Command.split(" ")[1]);
    }
}
