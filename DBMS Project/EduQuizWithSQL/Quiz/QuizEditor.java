package Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.InputMismatchException;
import java.util.Scanner;

import Database.DatabaseConn;
import Users.Teacher;

public class QuizEditor {

    // Menu for editing quizzes
    public static void editQuiz(Teacher teacher, Scanner scanner, Connection conn) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Edit Quiz ---\n");

            System.out.println("(1) Add Question");
            System.out.println("(2) Delete Question");
            System.out.println("(3) View Questions");
            System.out.println("(4) Back to Teacher Menu");

            System.out.print("\n\tChoose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> QuizEditor.addQuestion(teacher, scanner);
                    case 2 -> QuizEditor.deleteQuestion(teacher, scanner, conn);
                    case 3 -> QuizEditor.viewQuestions(teacher, scanner);
                    case 4 -> isRunning = false;
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid option.");
                scanner.nextLine();
            }
        }
    }

    // Add a question to the database
    public static void addQuestion(Teacher teacher, Scanner scanner) {
        try (Connection conn = DatabaseConn.getConnection()) {
            String subject = QuizUtils.promptForSubject(teacher, scanner);

            if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) {
                System.out.println("Unregistered subject. Returning to menu...");
                return;
            }

            System.out.println("\n(Enter 'back' at any prompt to return to the menu)");

            String questionText = QuizUtils.getValidatedInput(scanner, "Enter question text: ");
            if (questionText.equalsIgnoreCase("back")) return;
    
            String optionA = QuizUtils.getValidatedInput(scanner, "Enter choice A: ");
            if (optionA.equalsIgnoreCase("back")) return;
    
            String optionB = QuizUtils.getValidatedInput(scanner, "Enter choice B: ");
            if (optionB.equalsIgnoreCase("back")) return;
    
            String optionC = QuizUtils.getValidatedInput(scanner, "Enter choice C: ");
            if (optionC.equalsIgnoreCase("back")) return;
    
            String optionD = QuizUtils.getValidatedInput(scanner, "Enter choice D: ");
            if (optionD.equalsIgnoreCase("back")) return;

            String correctAnswer;
            while (true) {
                System.out.print("Enter correct answer (a/b/c/d): ");
                correctAnswer = scanner.nextLine().toLowerCase().trim();
                if ("abcd".contains(correctAnswer) && correctAnswer.length() == 1) break;
                System.out.println("Invalid input. Please enter only 'a', 'b', 'c', or 'd'.");
            }

            String sql = "INSERT INTO questions (subject, question_text, option_a, option_b, option_c, option_d, correct_answer, created_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, subject);
                pstmt.setString(2, questionText);
                pstmt.setString(3, optionA);
                pstmt.setString(4, optionB);
                pstmt.setString(5, optionC);
                pstmt.setString(6, optionD);
                pstmt.setString(7, correctAnswer);
                pstmt.setString(8, teacher.getFullname());
                pstmt.executeUpdate();
                System.out.println("\n\t**** Question added successfully! ****");
            }
        } catch (Exception e) {
            System.err.println("Error adding question: " + e.getMessage());
        }
    }

    // Delete a question from the database
    public static void deleteQuestion(Teacher teacher, Scanner scanner, Connection conn) {
        // Prompt the teacher for the question ID
        System.out.println("\n--- Delete Question ---\n");

       if (!viewQuestions(teacher, scanner)) {
        return; // Exit the method if no questions
        }

        System.out.println("\n(Enter 'back' to return to the menu)");
        System.out.print("\nEnter the ID of the question to delete: ");

        String input = scanner.nextLine().trim();
        if (input.equalsIgnoreCase("back")){ 
        System.out.print("\nGoing back.....\n");
        return;
        }
        
        // SQL query to delete the question based on ID and teacher's name
        String sql = "DELETE FROM questions WHERE id = ? AND created_by = ?";
    
        try {
            int questionId = Integer.parseInt(input);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, questionId); 
                stmt.setString(2, teacher.getFullname()); 
        
                int rowsAffected = stmt.executeUpdate(); 
        
                if (rowsAffected > 0) {
                    System.out.println("Question deleted successfully.");
                } else {
                    System.out.println("You cannot delete this question. Either it doesn't exist or it wasn't created by you.");
                }
            } catch (SQLException e) {
                System.out.println("Error deleting question: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid question ID.");
        }
    }
    
    // View questions in the database
    public static boolean viewQuestions(Teacher teacher, Scanner scanner) {
        boolean hasQuestions = false;
        try (Connection conn = DatabaseConn.getConnection()) {
            String subject = QuizUtils.promptForSubject(teacher, scanner);

            String sql = "SELECT id, question_text, option_a, option_b, option_c, option_d, correct_answer FROM questions WHERE subject = ? AND created_by = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, subject);
                pstmt.setString(2, teacher.getFullname());

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (!rs.isBeforeFirst()) { 
                        System.out.println("\nNo questions found for the subject '" + subject + "' created by you.");
                    } else {
                        hasQuestions = true;
                    while (rs.next()) {
                        System.out.print("\n(ID : " + rs.getString("id") + ") ");
                        System.out.println("\nQuestion: " + rs.getString("question_text"));
                        System.out.println("A: " + rs.getString("option_a"));
                        System.out.println("B: " + rs.getString("option_b"));
                        System.out.println("C: " + rs.getString("option_c"));
                        System.out.println("D: " + rs.getString("option_d"));
                        System.out.println("Correct Answer: " + rs.getString("correct_answer"));
                    }
                }
            }
        }
        } catch (Exception e) {
            System.err.println("Error viewing questions: " + e.getMessage());
        }
        return hasQuestions;
    }
}

