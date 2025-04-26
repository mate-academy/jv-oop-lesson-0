package mate.academy.service;

public class AuthenticationService {

    public boolean login(String email, String password) {

        for (int i = 0; i < UserService.getUsers().length; i++) {
            if (UserService.getUsers()[i].getEmail().equals(email)
                    && UserService.getUsers()[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
