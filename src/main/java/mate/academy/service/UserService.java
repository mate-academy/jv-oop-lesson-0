package mate.academy.service;

import mate.academy.model.User;

public class UserService {

    private static final User[] users = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmail(String email) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }
}
