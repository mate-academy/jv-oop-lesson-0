package mate.academy.service;

import mate.academy.model.User;

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
        //Create temporary variable for saving result of searching
        User temp = null;

        //Check each user in the database to find a suitable one
        //If it isn't found, it will be null
        for (User t : users) {
            if (t.getEmail().equals(email)) {
                temp = t;
            }
        }
        //Return the result of searching
        return temp;
    }
}
