package org.example.entities;

public class ShowCommand implements CommandProcessor {
    @Override
    public void process(String Command, UserBase userBase) {
        userBase.printBalance();
    }
}
