package splitwise;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit{


    @Override
    public void validateSplitRequest(List<SplitDetails> splitList, double totalAmount) {
        //validate total amount in splits of each user is equal and overall equals to totalAmount or not
        double amountShouldBePresent = totalAmount/splitList.size();
        for(SplitDetails split: splitList) {
            if(split.getAmountOwe() != amountShouldBePresent) {
                //throw exception
            }
        }
    }
}

