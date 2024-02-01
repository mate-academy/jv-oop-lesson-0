package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private User user;

    public AuthenticationService() {
        this.user = null;
    }

    public boolean login(String email, String password) {
        user = new UserService().findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
