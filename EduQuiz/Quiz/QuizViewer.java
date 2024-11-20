package Quiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Users.Teacher;

public class QuizViewer {

    public static void viewQuiz(Teacher teacher, Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- View Quiz Question---\n");

            System.out.println("(1) View My Question/s");
            System.out.println("(2) View All Subject Questions");
            System.out.println("(3) Back");

            System.out.print("\n\tPlease choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        viewMyQuiz(teacher, scanner);
                        break;

                    case 2:
                        viewAllQuestions(teacher, scanner);
                        break;

                    case 3:
                        System.out.println("Going back.....");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    public static void viewMyQuiz(Teacher teacher, Scanner scanner) {

        String subject = QuizUtils.promptForSubject(teacher, scanner);
        System.out.print("\n\t---- Here is your Question/s ----\n\n ");

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) {
            System.out.println("Unregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        QuizUtils.displayQuestions(QuizUtils.getTeacherQuestions(teacher, subject));
    }

    public static void viewAllQuestions(Teacher teacher, Scanner scanner) {

        System.out.println("Available subjects: " + teacher.getSubjects());
        String subject = QuizUtils.getValidatedInput(scanner, "Type your registered subject to view all questions: ")
                    .toLowerCase()
                    .replaceAll("\\s+", "");

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) {
            System.out.println("Y\nYou are not registered for the subject '" + subject + "'. Please choose a registered subject.");
            return;
        }

        // Get all questions for the subject
        ArrayList<QuestionMulti> questions = TakeQuiz.getQuizQuestions(subject);
        System.out.println("\n--- All Questions for Subject: " + subject + " ---\n");
        System.out.println("----------------------------\n");
        QuizUtils.displayQuestions(questions);
    }
}