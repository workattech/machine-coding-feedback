package service.impl;

import models.SplitModel;
import models.User;
import service.SplitStrategy;

import java.util.HashMap;
import java.util.Map;

public class ExactStartegy implements SplitStrategy {

    @Override
    public void split(User user, SplitModel splitModel) {

        Map<String  , Double > balanceSheet = user.getBalanceSheet();
        if(balanceSheet == null){
            balanceSheet = new HashMap<>();
            user.setBalanceSheet(balanceSheet);
        }

        for(int i = 0 ; i < splitModel.getFriends().size() ; i++ ){
            balanceSheet.put(splitModel.getFriends().get(i) ,
                    balanceSheet.getOrDefault( splitModel.getFriends().get(i) , 0.0)+ splitModel.getExactAmounts().get(i));
        }
    }
}
