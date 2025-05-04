package mate.academy.service;

import java.util.HashMap;
import java.util.Map;
import mate.academy.model.User;

class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    private Map<String, User> usersByEmail;

    public UserService() {
        this.usersByEmail = new HashMap<>();
        // Populate users for testing
        for (User user : users) {
            usersByEmail.put(user.getEmail(), user);
        }
    }

    /**
     * Find user by email. All users are stored in <code>private static final User[] users</code>
     *
     * @param email - the input parameter
     * @return - user if his email is equal to passed email.
     * Return <code>null</code> if there is no suitable user
     */
    public User findByEmail(String email) {
        return usersByEmail.get(email);
    }
}
