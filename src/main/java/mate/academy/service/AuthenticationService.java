package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    /**
     * Imagine that some user wants to login to your site.
     @@ -11,6 +13,11 @@ public class AuthenticationService {
      * Return false in any other cases.
     */
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User user = userService.findByEmail(email);
        if (user != null && user.getPassword() == password) {
            return true;
        }
        return false;
    }
}