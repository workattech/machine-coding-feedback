package src.snake_and_ladder;

public interface BoardEntity {
    boolean isPresent(int position);
    /**
     * 
     * @param position is the stasrting position.
     * @return the new position of a player after interacting with the entity.
     */
    int getDestinationPosition(int position);
}