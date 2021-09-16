package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService extends UserService {

    public boolean login(String email, String password) {
        User user = findByEmail(email);
        if (user == null) {
            return false;
        }
        return password.equals(user.getPassword());
    }
}
