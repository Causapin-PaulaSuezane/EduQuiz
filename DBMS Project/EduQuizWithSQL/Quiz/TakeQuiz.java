package Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.time.LocalDate;

import Database.DatabaseConn;

import java.util.ArrayList;
import java.util.Scanner;

import Users.Student;

public class TakeQuiz {

    private static Scanner scanner = new Scanner(System.in);

    // method to take quiz
    public static void takeQuiz(Student student, Scanner scanner) {
        System.out.println("\n--- Take Quiz ---\n");
        System.out.println("Available subjects: " + student.getSubjects()); // Display subjects the student has registered for
        System.out.print("Enter a subject for the quiz: ");
        String subject = scanner.nextLine().toLowerCase().replaceAll("\\s+", ""); // .toLowerCase to turn the user input to lowercase, .replaceAll to replace all whitespaces as none

        boolean subjectFound = false; //initialize that subjectFound is false
        for (String registeredSubject : student.getSubjects()) { // iterates through the subject that the user is currently assigned in and store it in the registeredSubject variable
            if (registeredSubject.toLowerCase().equals(subject)) { // if the value of registered subject is equals to the subject that the user typed in
                subjectFound = true; // return true
                try {
                    TakeQuiz.startQuiz(registeredSubject, student); // Start quiz for the valid subject
                } catch (Exception e) {
                    System.out.println("\nAn error occurred while starting the quiz. Please try again.");
                }
                break;
            }
        }

        if (!subjectFound) { // if the typed subject is not found in the student.getSubjects
            System.out.println("\nYou are not registered for the subject '" + subject + "'. Please choose a registered subject.");
        }
    }

    // method to start the quiz
    public static void startQuiz(String subject, Student student) {

        ArrayList<QuestionMulti> questions = getQuizQuestions(subject); // initialize an arraylist named "questions", fetches the quiz questions from the selected subject and stores them in the variable.

        System.out.println("\n===================== Welcome to the " + subject + " Quiz! =====================");
        System.out.println("\nAnswer the questions below.\n");

        int score = 0; // start the quiz with a score of 0
        for (QuestionMulti question : questions) {
            score += askQuestion(question); // adds 1 for every correct answer and retains the score for every wrong answer
        }

        // Update the score locally in the Student object
        student.setScore(student.getSubjects().indexOf(subject), score);

        // Update the score in the database
        updateScoreInDatabase(student.getUsername(), subject, score);

        System.out.println("\nYou answered " + score + " out of " + questions.size() + " questions correctly.");
    }

    // Method to fetch the questions according to the chosen subject to take a quiz at
    public static ArrayList<QuestionMulti> getQuizQuestions(String subject) {
        ArrayList<QuestionMulti> questions = new ArrayList<>();
        
        try (Connection connection = DatabaseConn.getConnection()) {
            String query = "SELECT question_text, option_a, option_b, option_c, option_d, correct_answer, created_by, subject FROM questions WHERE subject = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, subject);
                ResultSet rs = stmt.executeQuery();
    
                while (rs.next()) {
                    QuestionMulti question = new QuestionMulti(
                        rs.getString("question_text"),  // question
                        rs.getString("option_a"),      // optionA
                        rs.getString("option_b"),      // optionB
                        rs.getString("option_c"),      // optionC
                        rs.getString("option_d"),      // optionD
                        rs.getString("correct_answer"),// correctAnswer
                        rs.getString("created_by"),    // createdBy
                        rs.getString("subject")        // subject
                    );
                    questions.add(question);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return questions; // Return the list of questions
    }
    

    // Method to display quiz question in a format and validate the user's answer
    private static int askQuestion(QuestionMulti question) {
        System.out.println(question.getQuestion());
        System.out.println("a. " + question.getOptionA());
        System.out.println("b. " + question.getOptionB());
        System.out.println("c. " + question.getOptionC());
        System.out.println("d. " + question.getOptionD());
        System.out.println("\t\tCreated by: " + question.getCreatedBy());

        String userAnswer;
        while (true) {
            System.out.print("\nEnter your answer (a/b/c/d): ");
            userAnswer = scanner.nextLine().toLowerCase().trim();

            // Check if the input is one of the valid answers
            if (userAnswer.equals("a") || userAnswer.equals("b") || userAnswer.equals("c") || userAnswer.equals("d")) {
                break; // Exit loop if valid
            } else {
                System.out.println("Invalid input. Please enter 'a', 'b', 'c', or 'd'.");
            }
        }

        if (userAnswer.equals(question.getCorrectAnswer())) {
            System.out.println("===============================");
            System.out.println("||\tCorrect answer!\t     ||");
            System.out.println("===============================\n");
            return 1; // returns the integer 1 to the score
        } else {
            System.out.println("====================================================");
            System.out.println("||\tWrong answer. The correct answer is " + question.getCorrectAnswer() + "\t  ||");
            System.out.println("====================================================\n");
            return 0; // returns the integer 0 to the score
        }
    }

    // Method to update the student's score in the database
    public static void updateScoreInDatabase(String username, String subject, int score) {
        try (Connection connection = DatabaseConn.getConnection()) {
            LocalDate currentDate = LocalDate.now();
            String query = """
                INSERT INTO student_score (username, subject, score, date_taken)
                VALUES (?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE score = ?, date_taken = ?;
                """;
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, subject);
                statement.setInt(3, score);
                statement.setDate(4, Date.valueOf(currentDate)); // Set the current date
                statement.setInt(5, score);
                statement.setDate(6, Date.valueOf(currentDate));

                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Score updated successfully for " + username);
                } else {
                    System.out.println("No record found for student: " + username + " and subject: " + subject);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}