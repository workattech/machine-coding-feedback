import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    String name;
    int current_position=0;
    int previous_postion=0;
    int diceRollOut;

    public Player(String name){
        this.name=name;
    }

    public void updatePosition(int new_position){
        System.out.println("Player "+this.name+" rolled a "+diceRollOut+" and moved from "+current_position+" to "+new_position);
        previous_postion=current_position;
        current_position=new_position;
    }

    public String toString(){
        return this.name;
    }


}
