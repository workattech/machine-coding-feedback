package test.java.PhoneBook.AddTest;

import main.java.PhoneBook.Model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.PhoneBook.Base.Base;


public class AddUser extends Base {
    @Test(testName = "Add users")
    public void AddUsers(){
        for (User user : usersList)
            Assert.assertEquals(Boolean.TRUE, phoneBook.add(user));
        log("User added count of users:- " + usersList.size());
    }
}
