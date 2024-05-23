package mate.academy.model;

public class User {
    private static String password;
    private String email;

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
