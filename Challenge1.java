import java.util.ArrayList;
import java.util.Scanner;

public class Challenge1 {
    static Scanner scanner = new Scanner(System.in);

    // Store items for sale and user's cart
    ArrayList<Item> itemsForSale = new ArrayList<>();
    ArrayList<Item> cart = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(
            " __      __       .__                                __________      ___.                  __          \n" +
            "/  \\    /  \\ ____ |  |   ____  ____   _____   ____   \\______   \\ ____\\_ |__   ____ _____ _/  |_  ______\n" +
            "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\   |    |  _//  _ \\| __ \\_/ ___\\\\__  \\\\   __\\/  ___/\n" +
            " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |    |   (  <_> ) \\_\\ \\  \\___ / __ \\|  |  \\___ \\ \n" +
            "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >  |______  /\\____/|___  /\\___  >____  /__| /____  >\n" +
            "       \\/       \\/          \\/            \\/     \\/          \\/           \\/     \\/     \\/          \\/ "
        );

        // Hardcoded accounts
        String[] emails = {"student1@quinnipiac.edu", "student2@quinnipiac.edu"};
        String[] passwords = {"password1", "password2"};

        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < 3 && !loggedIn) {
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

                Challenge1 app = new Challenge1();
                app.initializeItems();

                boolean running = true;
                while (running) {
                    System.out.println("\nMain Menu:\n1. Buy\n2. Sell\n3. Cart\n4. Logout");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        app.buyMenu();
                    } else if (choice.equals("2")) {
                        app.sellMenu();
                    } else if (choice.equals("3")) {
                        app.cartMenu();
                    } else if (choice.equals("4")) {
                        System.out.println("Logged out.");
                        running = false;
                    } else {
                        System.out.println("Invalid option.");
                    }
                }

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

    // Initialize some items for sale
    void initializeItems() {
        itemsForSale.add(new Item("Textbook", "Books", "Alex", "alex@quinnipiac.edu", 50));
        itemsForSale.add(new Item("Laptop", "Electronics", "Bob", "bob@quinnipiac.edu", 500));
        itemsForSale.add(new Item("Backpack", "Clothing", "Dave", "dave@quinnipiac.edu", 30));
        itemsForSale.add(new Item("Calculator", "Electronics", "Eve", "eve@quinnipiac.edu", 25));
        itemsForSale.add(new Item("Desk Lamp", "Furniture", "Charlie", "charlie@quinnipiac.edu", 20));
    }

    // Buy menu
    void buyMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nItems for Sale:");
            for (int i = 0; i < itemsForSale.size(); i++) {
                System.out.println((i + 1) + ". " + itemsForSale.get(i).name);
            }
            System.out.println((itemsForSale.size() + 1) + ". Back to Main Menu");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice >= 1 && choice <= itemsForSale.size()) {
                Item selected = itemsForSale.get(choice - 1);
                System.out.println("1. View Details\n2. Add to Cart\n3. Back");
                String action = scanner.nextLine();

                if (action.equals("1")) {
                    selected.printDetails();
                } else if (action.equals("2")) {
                    cart.add(selected);
                    System.out.println(selected.name + " added to cart.");
                } else if (action.equals("3")) {
                    continue; // back to items list
                } else {
                    System.out.println("Invalid option.");
                }

            } else if (choice == itemsForSale.size() + 1) {
                isRunning = false;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    // Sell menu
    void sellMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nSell Menu:\n1. View Current Items Up For Sale\n2. Add A New Item For Sale\n3. Go Back");
            String userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                ItemsForSale();
            } else if (userInput.equals("2")) {
                addItem();
            } else if (userInput.equals("3")) {
                isRunning = false;
            } else {
                System.out.println("Invalid Input, Please Try Again");
            }
        }
    }


    //Cart menu
    void cartMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nCart:");
            double total = 0;
            for (int i = 0; i < cart.size(); i++) {
                System.out.println((i + 1) + ". " + cart.get(i).name + " - $" + cart.get(i).price);
                total += cart.get(i).price;
            }
            System.out.println("Total: $" + total);
            System.out.println("\n1. Checkout\n2. Back");
            String choice = scanner.nextLine();
    
            if (choice.equals("1")) {
                for (Item item : cart) {
                    itemsForSale.remove(item);
                }
                cart.clear();
                System.out.println("Purchase successful!");
            } else if (choice.equals("2")) {
                isRunning = false;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    void ItemsForSale() {
        System.out.println("Displaying items for sale...");
    }

    // Add a new item for sale
    void addItem() {
        System.out.println("Enter name of item:");
        String name = scanner.nextLine();
        System.out.println("Enter category of item:");
        String category = scanner.nextLine();
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter price:");
        double price = Double.parseDouble(scanner.nextLine());

        itemsForSale.add(new Item(name, category, firstName + " " + lastName, email, price));
        System.out.println("Item added!");
    }

    // Item class
    static class Item {
        String name;
        String category;
        String sellerName;
        String sellerEmail;
        double price;

        Item(String name, String category, String sellerName, String sellerEmail, double price) {
            this.name = name;
            this.category = category;
            this.sellerName = sellerName;
            this.sellerEmail = sellerEmail;
            this.price = price;
        }

        void printDetails() {
            System.out.println("Name: " + name);
            System.out.println("Category: " + category);
            System.out.println("Seller: " + sellerName + " (" + sellerEmail + ")");
            System.out.println("Price: $" + price);
        }
    }
}