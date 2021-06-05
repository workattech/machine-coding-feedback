package main.java.models;

public class Player {
  private String Name;
  private char chosenCharacter;

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public char getChosenCharacter() {
    return chosenCharacter;
  }

  public void setChosenCharacter(char chosenCharacter) {
    this.chosenCharacter = chosenCharacter;
  }
}
