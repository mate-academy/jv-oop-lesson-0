package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userServiceTest = new UserService();
        User testByEmail = userServiceTest.findByEmail(email);
        return testByEmail != null ? testByEmail.getPassword().equals(password) 
              : false;
    }
}
