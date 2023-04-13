package mate.academy.model;

public class User {
    private String email;
    private static String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}
