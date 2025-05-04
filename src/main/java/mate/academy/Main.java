package mate.academy;

import mate.academy.service.AuthenticationService;
import mate.academy.service.UserService;

public class Main {
    public static void main(String[] args) {
        test("bob@i.ua", "1234", true);
        test("alice@i.ua", "1234", true);
        test("john@i.ua", "1234", false);
        test("bob@i.ua", "qwerty", false);
    }

    private static void test(String email, String password, boolean expected) {
        UserService userService = new UserService();
        AuthenticationService authenticationService = new AuthenticationService(userService);

        boolean actual = authenticationService.login(email, password);
        if (expected == actual) {
            System.out.println("Test passed for email: " + email + " and password " + password);
        } else {
            System.out.print("Expected to receive " + expected + ", but was " + actual + ". ");
            System.out.println("Email: " + email + ", password " + password);
        }
    }
}
