import java.util.Scanner;

public class Challenge1{
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
    }


    void sellMenu() {
       
        boolean isRunning =true;
        while ( isRunning == true) { 
            System.out.println("Menu Options:   ");
            System.out.println("1. View Current Items Up For Sale");
            System.out.println("2. Add A New Item For Sale");
            System.out.println("3. Go Backto Main Menu");
            
            String userImput = scanner.nextLine();

            if (userImput.equals("1")) {
                isRunning = false;
                ViewItemsForSale();

            } else if (userImput.equals("2")) {
               isRunning = false;
                addItem();

            } else if (userImput.equals("3")) {
                isRunning = false;
                // Go back to main menu
            } else {
                System.out.println("Invalid Input, Please Try Again");
            }
        }
    }


    void viewItemsForSale() {
    System.out.println("\n--- MY ITEMS FOR SALE ---");

    boolean hasItems = false;

    for (Item item : itemsForSale) {
        // You may need to adjust this depending on how your team defines User
        if (item.seller != null && currentUser != null &&
            item.seller.email.equals(currentUser.email)) {

            System.out.println(item.name + " | " + item.category + " | $" + item.price);
            hasItems = true;
        }
    }

    if (!hasItems) {
        System.out.println("You have no items listed.");
    }
}


    void addItem() {
        System.out.println("\n--- ADD NEW ITEM ---");

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // VERY IMPORTANT

        
        Item newItem = new Item(name, category, price, currentUser);
        itemsForSale.add(newItem);
        System.out.println("Item added successfully!");
}

}