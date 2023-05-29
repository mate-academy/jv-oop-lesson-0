package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService service = new UserService();
        if (service.findByEmail(email) != null) {
            User user = service.findByEmail(email);
            return email.equals(user.getEmail()) && password.equals(user.getPassword());
        }
        return false;
    }
}
