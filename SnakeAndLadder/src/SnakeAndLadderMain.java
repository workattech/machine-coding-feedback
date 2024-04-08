import service.BoardService;

public class SnakeAndLadderMain {
    public static void main(String[] args) {
        BoardService service = new BoardService();
        service.initializeAndPlay();

    }
}