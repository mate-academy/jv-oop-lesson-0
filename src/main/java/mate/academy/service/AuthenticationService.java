package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {


    public boolean login(String email, String password) {
        for (User user : UserService.getUsers()) {
            if (email.equals(user.getEmail())) {
                if (password.equals(user.getPassword())) {
                    return true;
                }
            }
        }

        return false;
    }
}
