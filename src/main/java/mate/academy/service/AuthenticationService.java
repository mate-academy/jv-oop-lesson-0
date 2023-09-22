package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {

    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User[] getUsers = userService.getUsers();
        for (User user : getUsers) {
            if (user.getEmail() == email && user.getPassword() == password) {
                return true;
            }
        }
        return false;
    }
}
