package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Quiz.QuestionMulti;

public class QuestionDatabaseHandler {

    public static void insertQuestion(QuestionMulti question, String subject) {
        String insertQuery = "INSERT INTO questions (subject, question_text, choice_a, choice_b, choice_c, choice_d, correct_answer, created_by) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConn.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, subject);
            preparedStatement.setString(2, question.getQuestion());
            preparedStatement.setString(3, question.getOptionA());
            preparedStatement.setString(4, question.getOptionB());
            preparedStatement.setString(5, question.getOptionC());
            preparedStatement.setString(6, question.getOptionD());
            preparedStatement.setString(7, question.getCorrectAnswer());
            preparedStatement.setString(8, question.getCreatedBy());

            preparedStatement.executeUpdate();
            System.out.println("Question inserted successfully: " + question.getQuestion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

