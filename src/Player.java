/**
 * Created by Shreyansh97 on 7/9/19
 */

public class Player {
  private String name;
  private int position;
  
  public Player(String name) {
    this.name = name;
    position = 0;
  }
  
  public int getPosition() {
    return position;
  }
  
  public void setPosition(int position) {
    this.position = position;
  }
  
  public String getName() {
    return name;
  }
}
