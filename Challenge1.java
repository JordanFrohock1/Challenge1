import java.util.Scanner;

public class Challenge1{
    Scanner scanner = new Scanner(System.in);
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


    void sellMenu() {
       
        boolean isRunning =true;
        while ( isRunning == true) { 
            System.out.println("Menu Options:   ");
            System.out.println("View Current Items Up For Sale");
            System.out.println("Add A New Item For Sale");
            
            String userImput = scanner.nextLine();

            if (userImput.equals("View Current Items Up For Sale")) {
                isRunning = false;
                ItemsForSale();

            } else if (userImput.equals("Add A New Item For Sale")) {
               isRunning = false;
                addItem();

            } else {
                isRunning = true;
                System.out.println("Invalid Input, Please Try Again");
            }
        }
    }

    void ItemsForSale() {
        System.out.println("Displaying items for sale...");
    }

    void addItem() {
        System.out.println("Adding a new item for sale...");
    }
     
}