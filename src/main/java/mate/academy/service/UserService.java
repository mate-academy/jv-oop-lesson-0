package mate.academy.service;

import mate.academy.model.User;

import java.util.Arrays;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };
    /**
     * Find user by email. All users are stored in <code>private static final User[] users</code>
     * @param email - the input parameter
     * @return - user if his email is equal to passed email.
     * Return <code>null</code> if there is no suitable user
     */
    public User findByEmail(String email) {
        return Arrays.stream(users).filter(u -> u.getEmail().equals(email))
                .findAny()
                .orElse(null);
    }
}
