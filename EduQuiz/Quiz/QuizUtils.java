package Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Users.Teacher;

public class QuizUtils {

    private static ArrayList<QuestionMulti> scienceQuestions = new ArrayList<>();
    private static ArrayList<QuestionMulti> mathQuestions = new ArrayList<>();
    private static ArrayList<QuestionMulti> historyQuestions = new ArrayList<>();
    public static ArrayList<String> validSubjects = new ArrayList<>(Arrays.asList("math", "science", "history"));

    // Get all questions for a particular subject
    public static ArrayList<QuestionMulti> getQuestionsBySubject(String subject) {
        switch (subject.toLowerCase()) {
            case "science":
                return scienceQuestions;
            case "math":
                return mathQuestions;
            case "history":
                return historyQuestions;
            default:
                System.out.println("No questions found for subject: " + subject);
                return new ArrayList<>(); 
        }
    }

    // Adds question to the relevant subject's question list
    public static void addQuestion(String subject, QuestionMulti question) {
        switch (subject.toLowerCase()) { 
            case "science":
                scienceQuestions.add(question);
                break;
            case "math":
                mathQuestions.add(question);
                break;
            case "history":
                historyQuestions.add(question);
                break;
            default:
                System.out.println("Invalid subject: " + subject); 
        }
    }

    // Remove a question from the relevant subject's question list
    public static void removeQuestion(QuestionMulti question) {
        switch (question.getSubject().toLowerCase())  {
            case "science":
                scienceQuestions.remove(question);
                break;
            case "math":
                mathQuestions.remove(question);
                break;
            case "history":
                historyQuestions.remove(question);
                break;
            default:
                System.out.println("Invalid subject"); 
        }
    }


    

    // Validate subject
    public static boolean isTeacherRegisteredForSubject(Teacher teacher, String subject) {
        for (String registeredSubject : teacher.getSubjects()) {
            if (registeredSubject.equalsIgnoreCase(subject)) {
                return true;
            }
        }
        return false;
    }

    // Get teacher-created questions
    public static ArrayList<QuestionMulti> getTeacherQuestions(Teacher teacher, String subject) {
        ArrayList<QuestionMulti> filteredQuestions = getQuestionsBySubject(subject); 
        ArrayList<QuestionMulti> teacherQuestions = new ArrayList<>();
        for (QuestionMulti question : filteredQuestions) { 
            if (question.getCreatedBy().equalsIgnoreCase(teacher.getFullname())) { 
                teacherQuestions.add(question); 
            }
        }
        return teacherQuestions; 
    }

    // Display questions
    public static void displayQuestions(ArrayList<QuestionMulti> questions) {
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
        } else {
            for (int i = 0; i < questions.size(); i++) {
                System.out.println((i + 1) + ". " + questions.get(i).getQuestion());
                System.out.println("\n----------------------------\n");
            }
        }
    }

    // Prompt for subject input
    public static String promptForSubject(Teacher teacher, Scanner scanner) {
        System.out.println("Available subjects: " + teacher.getSubjects());
        String subject = getEmptyInput( scanner, "Enter subject: ").toLowerCase().replaceAll("\\s+", "");
        return subject;
    }

    //validates if the user entered nothing
    public static String getEmptyInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
    
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            } else {
                break; 
            }
        }
        return input;
    }
}
