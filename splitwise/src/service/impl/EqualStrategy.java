package service.impl;

import models.SplitModel;
import models.User;
import service.SplitStrategy;

import java.util.HashMap;
import java.util.Map;

public class EqualStrategy implements SplitStrategy {
    @Override
    public void split(User user, SplitModel splitModel) {

        Map<String  , Double > balanceSheet = user.getBalanceSheet();

        if(balanceSheet == null){
            balanceSheet = new HashMap<>();
            user.setBalanceSheet(balanceSheet);
        }

        for(String friends : splitModel.getFriends()){
           balanceSheet.put(friends , balanceSheet.getOrDefault(friends , 0.0) + splitModel.getAmount()/splitModel.getFriends().size());
        }
    }
}
