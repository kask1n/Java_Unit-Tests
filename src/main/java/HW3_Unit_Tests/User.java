package HW3_Unit_Tests;

// import java.util.Objects;

public class User {
    String name;
    String password;
    Boolean isAdmin;
    Boolean isAuth = false;

    public User(String name, String password, Boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean auth(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }
}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(isAdmin, user.isAdmin);
//    }
//
//    @Override
//    public int hashCode() {
//        return 31 * name.hashCode() + password.hashCode();
//    }
