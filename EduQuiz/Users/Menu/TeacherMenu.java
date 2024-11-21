package Users.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import Quiz.QuizEditor;
import Quiz.QuizViewer;
import Users.Teacher;

public class TeacherMenu {
    
    // teacher menu
    public static void showMenu(Teacher teacher, Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Teacher Menu ---\n");

            System.out.println("(1) View Profile");
            System.out.println("(2) Edit Quiz");
            System.out.println("(3) View Quiz Question");
            System.out.println("(4) Logout");
            
            System.out.print("\n\tPlease choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        teacher.viewProfile();
                        break;

                    case 2:
                        QuizEditor.editQuiz(teacher, scanner);
                        break;
                    
                    case 3:
                        QuizViewer.viewQuiz(teacher, scanner); 
                        break;
                    
                    case 4:
                        System.out.println("\n\t**** You have been logged out. ****");
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