package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {


    private static UserService findbyemail = new UserService();
    public boolean login(String email, String password) {
        String Email_for = findbyemail.findByEmail(email, password);
        if (Email_for != null){
            return true;
        }
        return false;
    }
}
