package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userIsNotNull = new UserService();
        User currentUser = new UserService().findByEmail(email);
        if (userIsNotNull.findByEmail(email) != null
                && userIsNotNull.findByEmail(email).getEmail().equals(email)
                && currentUser.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
