package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmail(String email) {
        User searchedUser = null;
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                searchedUser = user;
            }
        }
        return searchedUser;
    }
}
