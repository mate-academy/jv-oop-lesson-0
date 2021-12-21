package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        if (UserService.findByEmail(email) == null) {
            return false;
        } else {
            User userLog = UserService.findByEmail(email);
            if (userLog.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    /**
     * public boolean login(String email, String password) {
     *     User userLog = UserService.findByEmail(email);
     *     if( UserService.findByEmail(email) == null || !(userLog.getPassword().equals(password))){
     *        return false;
     *      }
     *         return true;
     *     }
     **/
}
