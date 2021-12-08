package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234"),
    };

    /**
     * Find user by email. All users are stored in <code>private static final User[] users</code>
     * @param email - the input parameter
     * @return - user if his email is equal to passed email.
     * Return <code>null</code> if there is no suitable user
     */
<<<<<<< HEAD
    public static User findByEmail(String email) {
=======
    public static  User findByEmail(String email) {
>>>>>>> 0dac24fdfa0a775c48ef4549ee59d00708748b5d
        for (int x = 0; x < users.length; x++) {
            if (email.equals(users[x].getEmail())) {
                return users[x];
            }
<<<<<<< HEAD
        }
        return null;
=======
        } return null;
>>>>>>> 0dac24fdfa0a775c48ef4549ee59d00708748b5d
    }
}
