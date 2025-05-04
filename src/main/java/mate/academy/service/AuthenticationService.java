package mate.academy.service;

public class AuthenticationService {
    private static final UserService findByEmail = new UserService();

    public boolean login(String email, String password) {
        String emailFor = findByEmail.findByEmail(email, password);
        return emailFor != null;
    }
}
