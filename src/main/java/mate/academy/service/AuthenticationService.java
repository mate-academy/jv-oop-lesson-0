package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService newName = new UserService();
        User userAvail = newName.findByEmail(email);
        if (userAvail == null) {
            return false;
        }
        if (userAvail.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
