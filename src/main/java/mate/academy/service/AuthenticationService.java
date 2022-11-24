package mate.academy.service;

public class AuthenticationService {

    private final UserService user = new UserService();

    public boolean login(String email, String password) {
        return user.findByEmail(email) != null
                && user.findByEmail(email).getPassword().equals(password);
    }
}
