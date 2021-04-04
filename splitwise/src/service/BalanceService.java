package service;

import models.User;

import java.util.List;

public interface BalanceService {
        public void listAllBalances(List<User> users);

        public void listBalance(User user);
}
