package mate.academy.service;

public class AuthenticationService {
    private static UserService findbyemail = new UserService();

    public boolean login(String email, String password) {
        String EmailFor = findbyemail.findByEmail(email, password);
        if (EmailFor != null) {
            return true;
        }
        return false;
    }
}
