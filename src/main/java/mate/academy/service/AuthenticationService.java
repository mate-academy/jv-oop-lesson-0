package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        return userService.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}


//        User user = userService.findByEmail(email);
//        return userService.findByEmail(email) != null ? user.getPassword().equals(password) : false;

//        return Optional.ofNullable(userService.findByEmail(email))
//                .map(user -> user.getPassword().equals(password))
//                .orElse(false);
