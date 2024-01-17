package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private boolean existUser;
    private UserService usersService = new UserService();

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
        User user = usersService.findByEmail(email);
        if (user != null) {
            if (user.getPassword() == password) {
                existUser = true;
            }
        } else {
            existUser = false;
        }
        return existUser;
    }
}
