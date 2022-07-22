package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User user = userService.findByEmail(email);
        return user.getPassword().equals(password) && user != null ? true : false;
        /* if (userAvail == null) {
            return false;
        }
        if (userAvail.getPassword().equals(password)) {
            return true;
        } */
        return false;
    }
}
