package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmail(String email) {
        for (User x : users) {
            if (x.getEmail().equals(email)) {
                return x;
            }
        }
        return null;
    }
}
