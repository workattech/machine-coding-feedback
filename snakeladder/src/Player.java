public class Player {

    private String name;

    private Integer position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Player(String name, Integer position) {
        this.name = name;
        this.position = position;
    }


    public void  makeMove(Integer turn, Board board){
        position = position + turn;

        if (board.ladderPosition.containsKey(position)){
            position = board.ladderPosition.get(position);
            System.out.println("Ladder  climbed :)"  );
        }
        else if (board.snakesPosition.containsKey(position)){
            position = board.snakesPosition.get(position);
            System.out.println("Snake Bite !!!"  );
        }


        if(position > 100){
            position = position - turn;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
