package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {

    public boolean login(String email, String password) {
        UserService users = new UserService();
        User user = users.findByEmail(email);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}
