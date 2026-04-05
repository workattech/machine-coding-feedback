package splitwise;

import java.util.List;

public interface ExpenseSplit {

    public void validateSplitRequest(List<SplitDetails> splitList, double totalAmount);
}


