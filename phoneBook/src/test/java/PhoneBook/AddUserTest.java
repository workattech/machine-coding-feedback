package test.java.PhoneBook;

import main.java.PhoneBook.Model.User;
import main.java.PhoneBook.PhoneBook;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.junit.Assert;
//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AddUserTest {


    @Test
    public void AddUsers(){

        PhoneBook phoneBook = new PhoneBook();

        List<User> users = new ArrayList<>();

        users.add(new User("Cat", "Tac", "1234567890"));
        users.add(new User("Dogo", "DRod", "7223023580"));
        users.add(new User("Dorid", "Drog", "8966850480"));
        users.add(new User("Jakma", "joko", "92133023580"));
        users.add(new User("Dogri", "Drogri", "9231301234"));
        users.add(new User("Abhishek", "Malviya", "7223023580"));

        for (User user : users) {
            Assert.assertEquals(Boolean.TRUE, phoneBook.add(user));
        }

    }
}
