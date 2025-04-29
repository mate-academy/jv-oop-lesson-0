package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private final UserService userService;

    // Ін'єкція залежності через конструктор
    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Перевіряє, чи існує користувач з таким email і чи пароль співпадає.
     * @param email - email користувача
     * @param password - пароль користувача
     * @return true, якщо користувач існує і пароль вірний; false у всіх інших випадках.
     */
    public boolean login(String email, String password) {
        if (email == null || password == null) {
            return false; // Захист від null-значень
        }

        User user = userService.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
