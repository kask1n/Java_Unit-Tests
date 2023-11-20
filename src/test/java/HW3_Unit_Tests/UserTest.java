package HW3_Unit_Tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void testAuthWithCorrectCredentials() {
        User user = new User("TestName", "TestPass", false);
        assertTrue(user.auth("TestName", "TestPass"));
    }

    @Test
    void testAuthWithIncorrectName() {
        User user = new User("TestName", "TestPass", false);
        assertFalse(user.auth("WrongName", "TestPass"));
    }

    @Test
    void testAuthWithIncorrectPass() {
        User user = new User("TestName", "TestPass", false);
        assertFalse(user.auth("TestName", "WrongPass"));
    }
}
