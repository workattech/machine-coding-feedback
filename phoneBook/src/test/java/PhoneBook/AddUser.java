package test.java.PhoneBook;

import main.java.PhoneBook.Model.User;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddUser extends Base {
    @Test(testName = "Add users")
    public void AddUsers(){
        for (User user : usersList)
            Assert.assertEquals(Boolean.TRUE, phoneBook.add(user));
        System.out.println("INFO User added count of users:- " + usersList.size());
    }
}
