package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {

    private final UserService user = new UserService();

    public boolean login(String email, String password) {
        User info = user.findByEmail(email);
        return info != null && info.getPassword().equals(password);
    }
}
