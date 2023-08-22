package mate.academy;

import mate.academy.service.authenticationService;

public class Main {
    private static final authenticationService authenticationService = new authenticationService();

    public static void main(String[] args) {
        test("bob@i.ua", "1234", true);
        test("alice@i.ua", "1234", true);
        test("john@i.ua", "1234", false);
        test("bob@i.ua", "qwerty", false);
    }

    private static void test(String email, String password, boolean expected) {
        boolean actual = authenticationService.login(email, password);
        if (expected == actual) {
            System.out.println("Test passed for email: " + email + " and password " + password);
        } else {
            System.out.print("Expected to receive " + expected + ", but was " + actual + ". ");
            System.out.println("Email: " + email + ", password " + password);
        }
    }
}
