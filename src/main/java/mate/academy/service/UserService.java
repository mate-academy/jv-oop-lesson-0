package mate.academy.service;

import mate.academy.model.User;

/**
 * Provides access to user data.
 */
public class UserService {
    private static final User[] USERS_REPOSITORY = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    /**
     * Finds a user by their email address.
     *
     * @param email the email to search for
     * @return the user with the specified email, or {@code null} if no such user exists
     */
    public User findByEmail(String email) {
        if (email == null) {
            return null;
        }

        for (User userEntry : USERS_REPOSITORY) {
            if (email.equals(userEntry.getEmail())) {
                return userEntry;
            }
        }
        return null;
    }
}
