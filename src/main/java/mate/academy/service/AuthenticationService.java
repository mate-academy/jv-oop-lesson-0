package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    User user;

    public boolean login(String email, String password) {
        user = new UserService().findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
