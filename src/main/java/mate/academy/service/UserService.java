package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static UserService instance;

    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234"),
            new User("john@i.ua", "6789")
    };

    private UserService() {
    }

    /**
     * Find user by email. All users are stored in <code>private static final User[] users</code>
     * @param email - the input parameter
     * @return - user if his email is equal to passed email.
     * Return <code>null</code> if there is no suitable user
     */

    public User findByEmail(String email) {
        for (int i = 0; i < users.length; i++) {
            if (email.equals(users[i].getEmail())) {
                return users[i];
            }
        }
        return null;
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
}
