package mate.academy.service;

import mate.academy.model.User;

import mate.academy.service.UserService;

public class AuthenticationService {
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

        UserService tempUserService = new UserService();
        User tempUser = tempUserService.findByEmail(email);

        if (password == null || tempUser == null) {
            return false;
        }

        String realPassword = tempUser.getPassword();


        return realPassword.equals(password);

    }
}
