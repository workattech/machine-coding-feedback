import java.util.*;
import java.io.*;

class Main{
    public static void main(String []args) throws IOException{
        int endPosition = 100;
        boolean isFinished = false;
        File file=new File("Input.txt");    //creates a new file instance  
        FileReader fr=new FileReader(file);
        BufferedReader br = new BufferedReader(fr);//(new InputStreamReader(System.in));
        HashMap<Integer,Integer> snakeMap = new HashMap<>();
        HashMap<Integer,Integer> ladderMap = new HashMap<>();
        HashMap<String,Integer> playerMap = new HashMap<>();

        int snakes = Integer.parseInt(br.readLine());
        for(int i=1;i<=snakes;i++){
            String str[] = br.readLine().split(" ");
            int head = Integer.parseInt(str[0]);
            int tail = Integer.parseInt(str[1]);
            snakeMap.put(head,tail);
        }

        int ladders = Integer.parseInt(br.readLine());
        for(int i=1;i<=ladders;i++){
            String str[] = br.readLine().split(" ");
            int head = Integer.parseInt(str[0]);
            int tail = Integer.parseInt(str[1]);
            ladderMap.put(head,tail);
        }
        
        
        int players = Integer.parseInt(br.readLine());
        for(int i=1;i<=players;i++){
            playerMap.put(br.readLine(),0);
        }
        fr.close();
        while(!isFinished){
            for(String player:playerMap.keySet()){
                int dice = rollDice();
                int currentPosition = playerMap.get(player);
                if(currentPosition+dice>100)
                   continue;
                int finalPosition = findPosition(currentPosition+dice,ladderMap,snakeMap);
                if(finalPosition==endPosition){
                    isFinished = true;
                    playerMap.put(player,endPosition);
                    System.out.println(player+" wins the game");
                    break;
                }
                else{
                    System.out.println(player+" rolled a "+dice+" and moved from "+currentPosition+" to "+finalPosition);
                    playerMap.put(player,finalPosition);
                }
            }
        }

    }

    public static int rollDice(){
        Random random = new Random();
        return 1+random.nextInt(6);
    }

    public static int findPosition(int targetPosition,HashMap<Integer,Integer> ladderMap,HashMap<Integer,Integer> snakeMap){
        
        if(!ladderMap.containsKey(targetPosition) && !snakeMap.containsKey(targetPosition)){
            // position doesn't have head of snake or a ladder
            return targetPosition;
        }
        else if(snakeMap.containsKey(targetPosition)){
            return findPosition(snakeMap.get(targetPosition),ladderMap,snakeMap);
        }
        else{
            return findPosition(ladderMap.get(targetPosition),ladderMap,snakeMap);
        }
    }

}