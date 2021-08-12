package mate.academy.service;

public class AuthenticationService {

    public boolean login(String email, String password) {
        UserService userService = new UserService();
        if (userService.findByEmail(email) != null) {
            return userService.findByEmail(email).getPassword().equals(password);
        }
        return false;
    }
}
