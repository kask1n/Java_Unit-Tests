package HW3_Unit_Tests;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void logoutNonAdminUsers() {
        for (User user : users) {
            if (!user.isAdmin)
                user.isAuth = false;
        }
    }
}
