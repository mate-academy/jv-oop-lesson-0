package mate.academy.service;

import mate.academy.model.User;
import java.util.List;

public class UserService {
    private final List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    /**
     * Find user by email. All users are stored in <code>private static final User[] users</code>
     * @param email - the input parameter
     * @return - user if his email is equal to passed email.
     * Return <code>null</code> if there is no suitable user
     */
    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    }
}
