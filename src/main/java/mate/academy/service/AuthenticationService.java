package mate.academy.service;

public class AuthenticationService {

    public boolean login(String email, String password) {
        boolean b = false;
        UserService userService = new UserService();
        if (userService.findByEmail(email) != null
                && userService.findByPassword(password) != null) {
            b = true;
        }
        return b;
    }
}
