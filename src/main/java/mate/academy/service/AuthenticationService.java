package mate.academy.service;
import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        User user = new UserService().findByEmail(email);
        if (user == null) {
            return false;
        }
        return password.equals(user.getPassword());
    }
}