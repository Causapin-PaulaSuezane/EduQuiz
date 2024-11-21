package Quiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Users.Teacher;

public class QuizEditor {

    // edit quiz menu
    public static void editQuiz(Teacher teacher, Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
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
                        isRunning = false;
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

    // method that adds a question in a selected subject
    public static void addQuestion(Teacher teacher, Scanner scanner) {

        String subject = QuizUtils.promptForSubject(teacher, scanner); // prompts which subject to add a question to
        System.out.println(""); // newline

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) { // if teacher is not registered to the selevted subject
            System.out.println("\nUnregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        // once subject is valid, proceed here
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

        QuestionMulti question = new QuestionMulti(questionText, optionA, optionB, optionC, optionD, correctAnswer, teacher.getFullname(), subject); // creates a new questio with the created method type
        QuizUtils.addQuestion(subject, question); // adds the current teacher-created question to the selected subject using a method in the QuizUtils class
        System.out.println("\n\t**** Question added by " + teacher.getFullname() + " to subject " + subject + ". ****");
    }


    // method to delete a selected question
    public static void deleteQuestion(Teacher teacher, Scanner scanner) {

        String subject = QuizUtils.promptForSubject(teacher, scanner); // prompts the user to enter subject

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) { // if current user is not registered to the selected subject
            System.out.println("\nUnregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        ArrayList<QuestionMulti> teacherQuestions = QuizUtils.getTeacherQuestions(teacher, subject); // fetches the questions created by the current teacher
        
        System.out.print("\n\t---- Here are your Question/s ----\n ");

        QuizUtils.displayQuestions(teacherQuestions); // displays the fetched questions

        if (!teacherQuestions.isEmpty()) { // if teacher's question is not empty
            System.out.print("\n(type any key to go back)\n");
            System.out.print("Enter the number of the question to delete: ");

            try {
                int questionIndex = scanner.nextInt();
                scanner.nextLine();

                if (questionIndex > 0 && questionIndex <= teacherQuestions.size()) { // a limit so if user typed an invalid number compared to the number of choices
                    QuizUtils.removeQuestion(teacherQuestions.get(questionIndex - 1)); // if user typed a valid number, itll get the selected question then deletes it
                    System.out.println("\n\t**** Question deleted. ****"); // successfully deleted
                } else {
                    System.out.println("Invalid choice. Going back..."); // the number input is not withing the choices
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Going back..."); // mismatch.. typing a charcter instead of an integer
                scanner.nextLine();
            }
        }
    }
}