package Quiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Users.Teacher;

public class QuizEditor {

    public static void editQuiz(Teacher teacher, Scanner scanner) {
        boolean editing = true;

        while (editing) {
            System.out.println("\n--- Edit Quiz ---\n");

            System.out.println("(1) Add Question");
            System.out.println("(2) Delete Question");
            System.out.println("(3) Back to Teacher Menu");
            
            System.out.print("\n\tChoose an option: ");
    
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        QuizEditor.addQuestion(teacher, scanner);
                        break;
    
                    case 2:
                        QuizEditor.deleteQuestion(teacher, scanner);
                        break;
    
                    case 3:
                        editing = false;
                        break;
    
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid option.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    public static void addQuestion(Teacher teacher, Scanner scanner) {

        String subject = QuizUtils.promptForSubject(teacher, scanner);
        System.out.println("");

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) {
            System.out.println("Unregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        String questionText = QuizUtils.getValidatedInput(scanner, "Enter question text: ");
        String optionA = QuizUtils.getValidatedInput(scanner, "Enter option A: ");
        String optionB = QuizUtils.getValidatedInput(scanner, "Enter option B: ");
        String optionC = QuizUtils.getValidatedInput(scanner, "Enter option C: ");
        String optionD = QuizUtils.getValidatedInput(scanner, "Enter option D: ");
    
        String correctAnswer;
        
        while (true) {
            System.out.print("Enter correct answer (a/b/c/d): ");
            correctAnswer = scanner.nextLine().toLowerCase().trim();

             if (correctAnswer.equals("a") || correctAnswer.equals("b") || correctAnswer.equals("c") || correctAnswer.equals("d")) {
                break;
            } else {
                System.out.println("\nInvalid input. Please enter only 'a', 'b', 'c', or 'd'.\n");
            }
        }

        QuestionMulti question = new QuestionMulti(questionText, optionA, optionB, optionC, optionD, correctAnswer, teacher.getFullname(), subject);
        QuizUtils.addQuestion(subject, question);
        System.out.println("\n\t**** Question added by " + teacher.getFullname() + " to subject " + subject + ". ****");
    }

    public static void deleteQuestion(Teacher teacher, Scanner scanner) {

        String subject = QuizUtils.promptForSubject(teacher, scanner);
        System.out.print("\n\t---- Here is your Question/s ----\n ");

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) {
            System.out.println("Unregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        ArrayList<QuestionMulti> teacherQuestions = QuizUtils.getTeacherQuestions(teacher, subject);
        QuizUtils.displayQuestions(teacherQuestions);

        if (!teacherQuestions.isEmpty()) {
            System.out.print("\n(type any key to go back)\n");
            System.out.print("Enter the number of the question to delete: ");

            try {
                int questionIndex = scanner.nextInt();
                scanner.nextLine();

                if (questionIndex > 0 && questionIndex <= teacherQuestions.size()) {
                    QuizUtils.removeQuestion(teacherQuestions.get(questionIndex - 1));
                    System.out.println("Question deleted.");
                } else {
                    System.out.println("Invalid choice. Going back...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Going back...");
                scanner.nextLine();
            }
        }
    }
}