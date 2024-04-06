package mate.academy.service;

public class AuthenticationService {
    private UserService userService = new UserService();

    public boolean login(String email, String password) {
        Object user = userService.findByEmail(email);
        if (user != null) {
            boolean loginUser = userService.findByEmail(email).getPassword().equals(password);
            return loginUser;
        }
        return false;
    }
}
