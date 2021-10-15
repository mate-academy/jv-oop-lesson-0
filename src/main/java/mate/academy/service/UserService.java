package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmail(String email) {
        User x = null;
        for (User user : users) {
            if (email == user.getEmail()) {
                x = user;
                break;
            }
        }
        return x;
    }

    public User findByPassword(String password) {
        User x = null;
        for (User user : users) {
            if (password == user.getPassword()) {
                x = user;
                break;
            }
        }
        return x;
    }
}
