package mate.academy.service;

import java.util.Objects;
import mate.academy.model.User;

public class AuthenticationService {
    private boolean existUser;

    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     * @param email - user's email
     * @param password - user's password
     * @return true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */
    public boolean login(String email, String password) {
        UserService usersService = new UserService();
        User user = usersService.findByEmail(email);
        existUser = Objects.equals(user.getPassword(), password);
        return existUser;
    }
}
