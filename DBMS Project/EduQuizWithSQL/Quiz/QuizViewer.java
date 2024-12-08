package Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                scanner.nextLine(); 
            }
        }
    }

    //view the current teacher's created question/s
    public static void viewMyQuiz(Teacher teacher, Scanner scanner) {
        String subject = QuizUtils.promptForSubject(teacher, scanner); // Prompts the teacher for the selected subject

        // Check if the teacher is registered for the subject
        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) {
            System.out.println("\nUnregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        System.out.println("\n\t---- Here are your Question/s ----\n");

        try (Connection conn = Database.DatabaseConn.getConnection()) {
            String sql = "SELECT id, question_text, option_a, option_b, option_c, option_d, correct_answer FROM questions WHERE subject = ? AND created_by = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, subject); 
                pstmt.setString(2, teacher.getFullname());

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("No questions found for the subject '" + subject + "' created by you.");
                    } else {
                        while (rs.next()) {
                            System.out.print("\n(ID : " + rs.getInt("id") + ") ");
                            System.out.println("Question: " + rs.getString("question_text"));
                            System.out.println("A: " + rs.getString("option_a"));
                            System.out.println("B: " + rs.getString("option_b"));
                            System.out.println("C: " + rs.getString("option_c"));
                            System.out.println("D: " + rs.getString("option_d"));
                            System.out.println("Correct Answer: " + rs.getString("correct_answer"));
                            System.out.println("-----------------------------");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error retrieving questions: " + e.getMessage());
        }
    }

    //method that views all the quiz questions including the teachers' created question in the selected subject 
    public static void viewAllQuestions(Teacher teacher, Scanner scanner) {

        System.out.println("Available subjects: " + teacher.getSubjects()); 
        String subject = QuizUtils.getValidatedInput(scanner, "Type your registered subject to view all questions: ")
                    .toLowerCase() 
                    .replaceAll("\\s+", ""); 

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