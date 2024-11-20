package Users.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import Quiz.TakeQuiz;
import Users.Student;

public class StudentMenu {

    public static void showMenu(Student student, Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Student Menu ---\n");

            System.out.println("(1) View Profile");
            System.out.println("(2) Take Quiz");
            System.out.println("(3) Logout");

            System.out.print("\n\tPlease choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        student.viewProfile();
                        break;
                    case 2:
                        TakeQuiz.takeQuiz(student, scanner);
                        break;
                    case 3:
                        System.out.println("You have been logged out.");
                        isRunning = false;
                        break;
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
