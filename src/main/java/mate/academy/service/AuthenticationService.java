package mate.academy.service;

public class AuthenticationService {

    private final UserService userService = new UserService();

    public boolean login(String email, String password) {
        return userService.findByEmail(email) != null
                && userService.findByEmail(email).getPassword().equals(password);
    }
}
