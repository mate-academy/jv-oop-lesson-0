package mate.academy.service;

public class AuthenticationService {

    public boolean login(String email, String password) {
        UserService userService = new UserService();
        if (userService.findByEmail(email) == null) {
            return false;
        }
        return userService.findByEmail(email).getEmail().equals(email)
                && userService.findByEmail(email).getPassword().equals(password);
    }
}
