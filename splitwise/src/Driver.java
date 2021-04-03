import models.SplitModel;
import models.User;
import service.BalanceService;
import service.SplitStrategy;
import service.impl.BalanceServiceImpl;
import service.impl.EqualStrategy;
import service.impl.ExactStartegy;
import service.impl.PercentStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Driver {


    public static void main(String [] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        BalanceService  balanceService = new BalanceServiceImpl();

        SplitStrategy equalStrategy = new EqualStrategy();
        SplitStrategy exactStrategy = new ExactStartegy();
        SplitStrategy percentStrategy = new PercentStrategy();
        try {
            Boolean flag = true;
            List<User> users = new ArrayList<>();

            users.add(new User("u1" , null));
            users.add(new User("u2" , null));
            users.add(new User("u3" , null));
            users.add(new User("u4" , null));
            while (flag) {
                String line = reader.readLine();
                String []tokens = line.split(" ");

                if(tokens[0].equals("1")) {
                    break;
                }else  if(tokens[0].equals("SHOW")){

                    if(tokens.length == 2){
                        for(User user : users ){
                            if (user.getUserId().equals(tokens[1])){
                                balanceService.listBalance(user);
                                break;
                            }
                        }
                    }else{
                        balanceService.listAllBalances(users);
                    }
                }else {

                    User currUser = null;
                    for(User user : users ){
                        if (user.getUserId().equals(tokens[1])){
                            currUser = user;break;
                        }
                    }

                    SplitModel splitModel = new SplitModel();
                    splitModel.setAmount(Double.parseDouble(tokens[2]));
                    List<String > friends = new ArrayList<>();

                    int count = Integer.parseInt(tokens[3]);
                    for(int i = 4 ; i < 4 + count ; i++ )
                        friends.add(tokens[i]);

                    int j =  4 + count;

                    splitModel.setFriends(friends);
                    if(tokens[j].equals("EQUAL")){
                        System.out.println("Split Model "+ splitModel );
                        equalStrategy.split(currUser , splitModel);
                    }else if(tokens[j].equals("EXACT")){
                        List<Double > exactAmounts = new ArrayList<>();
                        for(int k = j ; k < j+ count ; k++){
                            exactAmounts.add(Double.parseDouble(tokens[k]));
                        }
                        splitModel.setExactAmounts(exactAmounts);
                        exactStrategy.split(currUser , splitModel);
                    }else{
                        List<Double > percentages = new ArrayList<>();
                        for(int k = j ; k < j+ count ; k++){
                            percentages.add(Double.parseDouble(tokens[k]));
                        }
                        splitModel.setPercentage(percentages);
                        percentStrategy.split(currUser , splitModel);
                    }

                }


            }
        }catch (Exception e){
            System.out.println("Error in reading input" + e.getMessage());
        }
    }
}
