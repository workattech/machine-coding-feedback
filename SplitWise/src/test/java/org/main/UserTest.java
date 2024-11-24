package org.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTest {

    @Test
    void generateUserID() {
        User user = spy(new User("Mahesh", "334156413", "mahesh@bidgely.com"));
        System.out.println(user.generateUserID());
    }
}