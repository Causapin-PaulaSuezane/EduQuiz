package Quiz;

import java.util.ArrayList;
import java.util.Scanner;

import Quiz.QuizSubjects.HistoryQuiz;
import Quiz.QuizSubjects.MathQuiz;
import Quiz.QuizSubjects.ScienceQuiz;
import Users.Student;

public class TakeQuiz {

    private static Scanner scanner = new Scanner(System.in);

    public static void takeQuiz(Student student, Scanner scanner) {
        System.out.println("\n--- Take Quiz ---\n");
        System.out.println("Available subjects: " + student.getSubjects()); // Display subjects the student has registered for
        System.out.print("Enter a subject for the quiz: ");
        String subject = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        boolean subjectFound = false;
        for (String registeredSubject : student.getSubjects()) {
            if (registeredSubject.toLowerCase().equals(subject)) {
                subjectFound = true;
                try {
                    TakeQuiz.startQuiz(registeredSubject, student); // Start quiz for the valid subject
                } catch (Exception e) {
                    System.out.println("\nAn error occurred while starting the quiz. Please try again.");
                }
                break;
            }
        }

        if (!subjectFound) {
            System.out.println("\nYou are not registered for the subject '" + subject + "'. Please choose a registered subject.");
        }
    }

    public static void startQuiz(String subject, Student student) {
        ArrayList<QuestionMulti> questions = getQuizQuestions(subject);

        System.out.println("\n===================== Welcome to the " + subject + " Quiz! =====================");
        System.out.println("Answer the questions below.");
        
        int score = 0;
        for (QuestionMulti question : questions) {
            score += askQuestion(question);
        }

        student.setScore(student.getSubjects().indexOf(subject), score);
        System.out.println("\nYou answered " + score + " out of " + questions.size() + " questions correctly.");
    }

    public static ArrayList<QuestionMulti> getQuizQuestions(String subject) {
        switch (subject.toLowerCase()) {
            case "math":
                return MathQuiz.getQuestions();
            case "science":
                return ScienceQuiz.getQuestions();
            case "history":
                return HistoryQuiz.getQuestions();
            default:
                System.out.println("Invalid subject.");
                return new ArrayList<>(); // Return empty list if subject is invalid
        }
    }

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
            return 1;
        } else {
            System.out.println("====================================================");
            System.out.println("||\tWrong answer. The correct answer is " + question.getCorrectAnswer() + "\t  ||");
            System.out.println("====================================================\n");
            return 0;
        }
    }
}
