package mate.academy.service;

public class AuthenticationService {
    private static final UserService userService = new UserService();

    public boolean login(String email, String password) {
        if (userService.findByEmail(email) != null
                && userService.findByEmail(email).getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
