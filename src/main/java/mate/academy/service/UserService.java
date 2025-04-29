package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    /**
     * Знаходить користувача за email у масиві `users`.
     * @param email - вхідний параметр (email користувача)
     * @return - повертає користувача, якщо його email співпадає.
     * Повертає `null`, якщо користувача не знайдено.
     */
    public User findByEmail(String email) {
        if (email == null) {
            return null; // Захист від null-значень
        }

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user; // Знайдено користувача
            }
        }

        return null; // Користувача не знайдено
    }
}
