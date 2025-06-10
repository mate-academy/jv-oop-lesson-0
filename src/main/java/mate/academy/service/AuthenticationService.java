package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User foundUser = userService.findByEmail(email);
        if (foundUser != null && password.equals(foundUser.getPassword())) {
            return true;
        }

        return false;
    }

}
