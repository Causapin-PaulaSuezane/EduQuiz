import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import Register.RegisterFunction;
import Users.User;

public class Main {
    static ArrayList<User> users = new ArrayList<>(); // creates an array list to store all the users
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=========================================\n");

            System.out.println("\tHi! Welcome to EduQuiz!");
            System.out.println("\n\t(1) Sign Up");
            System.out.println("\t(2) Login");
            System.out.println("\t(3) Exit");
            
            System.out.print("\nEnter choice : ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        RegisterFunction.signUp(scanner, users);
                        break;
                    case 2:
                        RegisterFunction.login(scanner, users);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}
