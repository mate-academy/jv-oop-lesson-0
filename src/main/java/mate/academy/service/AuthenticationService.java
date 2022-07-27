package mate.academy.service;

import java.util.Objects;
import mate.academy.model.User;

public class AuthenticationService {

    public boolean login(String email, String password) {
        User user = new UserService().findByEmail(email);

        if (user != null) {
            return Objects.equals(password, user.getPassword());
        }

        return false;
    }
}
