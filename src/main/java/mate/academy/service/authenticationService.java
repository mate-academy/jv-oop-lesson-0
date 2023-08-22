package mate.academy.service;

import mate.academy.model.User;

public class authenticationService {
UserService userService = new UserService();
User [] users = userService.getUsers();

    public boolean login (String email,String password) {
for (User user : users) {
    if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
        return true;
    }

}
        return false;
    }
    }

