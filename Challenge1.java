import java.util.Scanner;

public class Challenge1{
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
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

    
    
    
    
    
}