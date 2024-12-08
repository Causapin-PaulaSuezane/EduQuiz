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
                        QuizEditor.removeQuestion(teacher, scanner);
                        break;
    
                    case 3:
                        isRunning = false;
                        break;
    
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid option.");
                scanner.nextLine(); 
            }
        }
    }

    // method that adds a question in a selected subject --FOR TEACHER CREATED QUESTIONS
    public static void addQuestion(Teacher teacher, Scanner scanner) {

        String subject = QuizUtils.promptForSubject(teacher, scanner); 
        System.out.println("");

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) { 
            System.out.println("\nUnregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        // once subject is valid, proceed here
        String questionText = QuizUtils.getEmptyInput(scanner, "Enter question text: ");
        String optionA = QuizUtils.getEmptyInput(scanner, "Enter option A: ");
        String optionB = QuizUtils.getEmptyInput(scanner, "Enter option B: ");
        String optionC = QuizUtils.getEmptyInput(scanner, "Enter option C: ");
        String optionD = QuizUtils.getEmptyInput(scanner, "Enter option D: ");
    
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


    // method to delete a selected question
    public static void removeQuestion(Teacher teacher, Scanner scanner) {

        String subject = QuizUtils.promptForSubject(teacher, scanner); 

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) { 
            System.out.println("\nUnregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        ArrayList<QuestionMulti> teacherQuestions = QuizUtils.getTeacherQuestions(teacher, subject); 
        
        System.out.print("\n\t---- Here are your Question/s ----\n ");

        QuizUtils.displayQuestions(teacherQuestions); 

        if (!teacherQuestions.isEmpty()) { 
            System.out.print("\n(type any key to go back)\n");
            System.out.print("Enter the number of the question to delete: ");

            try {
                int questionIndex = scanner.nextInt();
                scanner.nextLine();

                if (questionIndex > 0 && questionIndex <= teacherQuestions.size()) { 
                    QuizUtils.removeQuestion(teacherQuestions.get(questionIndex - 1));
                    System.out.println("\n\t**** Question deleted. ****"); 
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