package Quiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Users.Teacher;

public class QuizViewer {

    //view quiz menu
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

    //view the current teacher's created question/s
    public static void viewMyQuiz(Teacher teacher, Scanner scanner) {

        String subject = QuizUtils.promptForSubject(teacher, scanner); // a method that prompts the teacher to type her selected subject

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) {
            System.out.println("\nUnregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        System.out.print("\n\t---- Here are your Question/s ----\n\n ");

        QuizUtils.displayQuestions(QuizUtils.getTeacherQuestions(teacher, subject)); // displays the the fethced questions that the current teacher has created
    }

    //method that views all the quiz questions including the teachers' created question in the selected subject 
    public static void viewAllQuestions(Teacher teacher, Scanner scanner) {

        System.out.println("Available subjects: " + teacher.getSubjects()); //displays the subject that the current teacher is registered for
        String subject = QuizUtils.getEmptyInput(scanner, "Type your registered subject to view all questions: ")
                    .toLowerCase() //lowercases the input of the current user
                    .replaceAll("\\s+", ""); //removes all whitespaces in the input of the current user

        // If teacher typed an unregistered subject
        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) {
            System.out.println("\nYou are not registered for the subject '" + subject + "'. Please choose a registered subject.");
            return; //back to the previous menu
        }

        // Get all questions for the subject
        ArrayList<QuestionMulti> questions = TakeQuiz.getQuizQuestions(subject);
        
        System.out.println("\n--- All Questions for Subject: " + subject + " ---\n");
        System.out.println("----------------------------\n");
        QuizUtils.displayQuestions(questions); // displays the question
    }
}