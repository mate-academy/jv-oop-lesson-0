package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private User[] users;

    public UserService(User[] users) {
        this.users = users;
    }

    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
