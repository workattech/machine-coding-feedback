package players;

import dice.Dice;

public class Player {
	public String name;
    public Peice peice;

    public Player(String nameval){
        name = nameval;
        peice = new Peice();
    }
        
    public int rolldice(Dice dice){
        int points = dice.generateScore();
        peice.move(points);
        return points;
    }
}
