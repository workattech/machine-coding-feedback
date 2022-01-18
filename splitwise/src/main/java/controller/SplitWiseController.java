package controller;

import domain.RequestObject;
import domain.User;
import service.SplitWiseService;

import java.util.List;

public class SplitWiseController {
    private final SplitWiseService splitWiseService;

    public SplitWiseService getSplitWiseService() {
        return splitWiseService;
    }

    public SplitWiseController(List<User> initialUserList) {
        splitWiseService = new SplitWiseService(initialUserList);
    }

    public void splitAmount(final RequestObject requestObject) {
        splitWiseService.splitAmount(requestObject);
    }

    public void showAll() {
        splitWiseService.showAll();
    }
}
