package service;

import models.SplitModel;
import models.User;



public interface SplitStrategy {
    public void split(User user , SplitModel splitModel);
}
