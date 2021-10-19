package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {

    public boolean login(String email, String password) {

        UserService us = new UserService();
        User user = us.findByEmail(email);
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
