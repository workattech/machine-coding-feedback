
public class Snake {
    private int startPosition;
    private int endPosition;

    public Snake(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public Response checkLadderAtLocation(int location){
        if(location == startPosition){
            return new Response(true,endPosition);
        }
        return new Response(false,-1);
    }


    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
