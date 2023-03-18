/**
 * Created by Shreyansh97 on 7/9/19
 */

public class Board {
  private int size;
  private int[] board;
  
  public Board(int size) {
    this.size = size;
    board = new int[size + 1];
    for (int i = 0; i <= size; i++) {
      board[i] = i;
    }
  }
  
  private int find(int pos) {
    if (board[pos] != pos) {
      board[pos] = find(board[pos]);
    }
    return board[pos];
  }
  
  public void addSnake(int head, int tail) {
    assert head > tail;
    board[head] = find(tail);
  }
  
  public void addLadder(int start, int end) {
    assert start < end;
    board[start] = find(end);
  }
  
  public int getPositionAfterMove(int initial, int shift) {
    if(initial + shift > size)
      return initial;
    return find(initial + shift);
  }
  
  public int getSize() {
    return size;
  }
}
