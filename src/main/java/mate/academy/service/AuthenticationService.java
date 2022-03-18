package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService user = new UserService();
        User auth = user.findByEmail(email);
        if (auth != null) {
            if (email.equals(auth.getEmail())) {
                return password.equals(auth.getPassword());
            }
        }
        return false;
    }
}
