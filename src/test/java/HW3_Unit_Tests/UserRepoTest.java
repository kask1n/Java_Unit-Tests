package HW3_Unit_Tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepoTest {
    @Test
    void testLogoutNonAdminUsers() {
        UserRepo userRepo = new UserRepo();

        User adminUser = new User("admin", "admin", true);
        User nonAdminUser1 = new User("user1", "123", false);
        User nonAdminUser2 = new User("user2", "qwerty", false);

        userRepo.addUser(adminUser);
        userRepo.addUser(nonAdminUser1);
        userRepo.addUser(nonAdminUser2);

        adminUser.isAuth = true;
        nonAdminUser1.isAuth = false;
        nonAdminUser2.isAuth = false;
        userRepo.logoutNonAdminUsers();

        assertFalse(nonAdminUser1.isAuth);
        assertFalse(nonAdminUser2.isAuth);
        assertTrue(adminUser.isAuth);
    }
}
