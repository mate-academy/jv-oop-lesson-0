package mate.academy.model;

public class User {
    private static String password;
    private final String email;

    public User(String email, String password) {
        this.email = email;
        User.password = password;
    }

    public String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}
