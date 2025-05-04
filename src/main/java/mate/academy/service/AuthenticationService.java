package mate.academy.service;

public class AuthenticationService {
    private final UserService userService = new UserService();

    public boolean login(String email, String password) {
        if (email == null || password == null) {
            return false;
        }
        if (userService.findByEmail(email) != null) {
            return userService.findByEmail(email).getPassword().equals(password);
        }
        return false;
    }
}
