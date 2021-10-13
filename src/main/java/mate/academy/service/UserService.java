package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final String EMAIL_MATCHER = "[A-Za-z].*?@i\\.ua";
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
        if (email.matches(EMAIL_MATCHER)) {
            for (User user : users) {
                if (user.getEmail() == email) {
                    return user;
                }
            }
        }
        return null;
    }
}
