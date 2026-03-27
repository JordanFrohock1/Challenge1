import java.util.Scanner;

public class Challenge1{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println(" __      __       .__                                __________      ___.                  __          \n" + //
                        "/  \\    /  \\ ____ |  |   ____  ____   _____   ____   \\______   \\ ____\\_ |__   ____ _____ _/  |_  ______\n" + //
                        "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\   |    |  _//  _ \\| __ \\_/ ___\\\\__  \\\\   __\\/  ___/\n" + //
                        " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |    |   (  <_> ) \\_\\ \\  \\___ / __ \\|  |  \\___ \\ \n" + //
                        "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >  |______  /\\____/|___  /\\___  >____  /__| /____  >\n" + //
                        "       \\/       \\/          \\/            \\/     \\/          \\/           \\/     \\/     \\/          \\/ ");

        
        // Hardcoeded accounts
        String[] emails = { "student1@quinnipiac.edu", "student2@quinnipiac.edu"};
        String[] passwords = {"password1", "password2"};

        int attempts = 0;
        boolean loggedIn = false;

        while(attempts < 3 && !loggedIn) {
            System.out.println("Please enter your Quinnipiac email: ");
            String username = scanner.nextLine();

            System.out.println("Please enter your password: ");
            String password = scanner.nextLine();

            boolean valid = false;

            // Check login
            for (int i = 0; i < emails.length; i++) {
                if (emails[i].equals(username) && passwords[i].equals(password)) {
                    valid = true;
                    break;
                }
            }

            if (valid) {
                System.out.println("Login successful. Welcome!");
                loggedIn = true;
            } else {
                attempts++;
                System.out.println("Invalid email or password.");

                if (attempts < 3) {
                    System.out.println("Attempts remaining: " + (3 - attempts));
                }
            }
        }
        
        if (!loggedIn) {
                System.out.println("Your account has been locked due to suspicious activity.");
                System.exit(0);
            }
            scanner.close();
        
    }
}