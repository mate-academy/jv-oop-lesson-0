package mate.academy.service;

public class AuthenticationService {

    public boolean login(String email, String password) {
        //just test
        if (UserService.findByEmail(email) == null) {
            return false;
        }
        if (password != UserService.findByEmail(email).getPassword()) {
            return false;
        }
        return true;
    }
}
