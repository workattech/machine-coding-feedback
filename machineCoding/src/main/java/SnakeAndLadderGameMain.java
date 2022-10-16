import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SnakeAndLadderGameMain {

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);

        int numberOfsnakes=scanner.nextInt();
        int[][] snakesStartAndEnd=new int[numberOfsnakes][2];
        for(int i=0;i<numberOfsnakes;i++){
            snakesStartAndEnd[i][0]=scanner.nextInt();
            snakesStartAndEnd[i][1]=scanner.nextInt();
        }

        int numberOfLadders=scanner.nextInt();
        int[][] laddersStartAndEnd=new int[numberOfLadders][2];
        for(int i=0;i<numberOfLadders;i++){
            laddersStartAndEnd[i][0]=scanner.nextInt();
            laddersStartAndEnd[i][1]=scanner.nextInt();
        }

        int numOfPlayers=scanner.nextInt();

        SnakeAndLadderService.startGame(snakesStartAndEnd,laddersStartAndEnd,numOfPlayers);




    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
