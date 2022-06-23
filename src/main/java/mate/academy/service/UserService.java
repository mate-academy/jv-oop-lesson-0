package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    /**
     * Find user by email. All users are stored in <code>private static final User[] users</code>
     *
     * @param email - the input parameter
     * @return - user if his email is equal to passed email.
     * Return <code>null</code> if there is no suitable user
     */
    public User findByEmail(String email) {
        String user1_email = "bob@i.ua";
        String user2_email = "alice@i.ua";
        for (User i : users) {
            if (i.getEmail().equals(user1_email) || i.getEmail().equals(user2_email)) {
                return i;
            }
        }
        return null;
    }
}
