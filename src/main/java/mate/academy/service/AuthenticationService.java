package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userData = new UserService();
        User authentication = userData.findByEmail(email);
        if (authentication != null) {
            return email.equals(authentication.getEmail())
                    && password.equals(authentication.getPassword());
        } else {
            return false;
        }
    }
}
