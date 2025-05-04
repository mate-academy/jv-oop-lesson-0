package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    /**
     * Imagine that some user wants to log in to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     *
     */
    private final UserService userService;

    public AuthenticationService() {
        this.userService = new UserService();
    }

    public boolean login(String password, String email) {
        User user = userService.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
