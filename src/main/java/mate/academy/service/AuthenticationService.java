package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService = new UserService();

    public boolean login(String email, String password) {
        User currentUser = userService.findByEmail(email);
        return currentUser == null ? false
                : currentUser.getEmail().equals(email)
                        && currentUser.getPassword().equals(password);
    }
}
