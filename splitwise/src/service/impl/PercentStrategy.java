package service.impl;

import models.SplitModel;
import models.User;
import service.SplitStrategy;

import java.util.Map;

public class PercentStrategy implements SplitStrategy {
    @Override
    public void split(User user, SplitModel splitModel) {

        Map<String  , Double > balanceSheet = user.getBalanceSheet();

        for(String friends : splitModel.getFriends()){
            balanceSheet.put(friends ,
                    balanceSheet.getOrDefault(friends , 0.0) + splitModel.getAmount()*splitModel.getFriends().size());
        }
    }
}
