package Register;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Database.DatabaseConn;

import Users.Student;
import Users.Teacher;
import Users.User;

import Users.Menu.StudentMenu;
import Users.Menu.TeacherMenu;

import Quiz.QuizUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterFunction {

    // Method to handle user sign up process
    public static void signUp(Scanner scanner, ArrayList<User> users) {
        int role = getRoleSelection(scanner);
        if (role == 3) return; // Back to main menu if user selects "Back"

        // User signup details
        String username = getUniqueUsername(scanner, users);
        if (username == null) {
            return; // Exit or go back to main menu
        }

        String password = QuizUtils.getValidatedInput(scanner, "Enter password: ");
        String fullname = QuizUtils.getValidatedInput(scanner, "Enter full name: ");

        // Subject selection
        ArrayList<String> selectedSubjects = selectSubjects(scanner);

        // Register user to the selected role
        registerToRole(role, username, password, fullname, selectedSubjects, users);
    }

    // Login method with correct menu redirection
    public static void login(Scanner scanner, ArrayList<User> users) {
        System.out.println("\n=========================================");
        System.out.println("\nLet's Log you in! (type \"back\" to go back to Main Menu.)");

        String username;

        while (true) {
            username = QuizUtils.getValidatedInput(scanner, "\nEnter username: ");

            if (username.replaceAll("\\s+", "").equalsIgnoreCase("back")) {
                System.out.println("Going back to Main Menu.......");
                return;
            }
            break;
        }

        String password = QuizUtils.getValidatedInput(scanner, "Enter password: ");

        // SQL Connection
        try (Connection conn = DatabaseConn.getConnection()) {
            // Check if user is a student
            String studentQuery = "SELECT * FROM students WHERE username = ? AND password = ?";

            try (PreparedStatement stmt = conn.prepareStatement(studentQuery)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("\n\t**** Login successful! (Student) ****");

                        // Fetch subjects for the student
                        ArrayList<String> subjects = getSubjects(username, 1, conn);

                        // Create a Student object with subjects (using existing constructor)
                        Student student = new Student(
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("full_name"),
                            subjects,
                            0 // Default score
                        );

                        // Pass student object to menu
                        StudentMenu.showMenu(student, scanner);
                        return;
                    }
                }
            }

            // Check if user is a teacher
            String teacherQuery = "SELECT * FROM teachers WHERE username = ? AND password = ?";

            try (PreparedStatement stmt = conn.prepareStatement(teacherQuery)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("\n\t**** Login successful! (Teacher) ****");

                        // Fetch subjects for the teacher
                        ArrayList<String> subjects = getSubjects(username, 2, conn);

                        // Create a Teacher object with subjects (using existing constructor)
                        Teacher teacher = new Teacher(
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("full_name"),
                            subjects
                        );

                        // Pass teacher object to menu
                        TeacherMenu.showMenu(teacher, scanner, conn);
                        return;
                    }
                }
            }
            // If no match found
            System.out.println("Invalid username or password.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while connecting to the database.");
        }
    }

////////////////////////////////////////////////////////methods below

    // Role selection method
    private static int getRoleSelection(Scanner scanner) {
        int role = 0;
        while (true) {
            System.out.println("\n=========================================");
            System.out.println("New here? Please select your role:");
            System.out.println("\t(1) Student");
            System.out.println("\t(2) Teacher");
            System.out.println("\t(3) Back");
            System.out.print("Enter choice: ");
            try {
                role = scanner.nextInt();
                scanner.nextLine();
                if (role == 3) {
                    System.out.println("Going back to Main Menu...");
                    break;
                } else if (role < 1 || role > 3) {
                    System.out.println("Invalid choice. Please select a valid option.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return role;
    }

    // Register user based on role
    private static void registerToRole(int role, String username, String password, String fullname, ArrayList<String> selectedSubjects, ArrayList<User> users) {
        User user = null;
        switch (role) {
            case 1:
                user = new Student(username, password, fullname, selectedSubjects, 0);
                break;
            case 2:
                user = new Teacher(username, password, fullname, selectedSubjects);
                break;
        }
        if (user != null) {
            boolean isRegistered = saveUserToDatabase(role, username, password, fullname, selectedSubjects);
            if (isRegistered) {
                System.out.println("\n=============================================");
                System.out.println("||\t**** " + user.getRole() + " Registered! ****      ||");
                System.out.println("=============================================");
                user.displayRole(); // Display role-specific details
            } else {
                System.out.println("\nRegistration failed. Please try again.");
            }
        }
    }

    // Check if username is unique
    private static String getUniqueUsername(Scanner scanner, ArrayList<User> users) {
        String username;
        while (true) {
            System.out.println("\n(type \"back\" now to go back to Main Menu.)");
            username = QuizUtils.getValidatedInput(scanner, "Enter username: ");
            if (username.replaceAll("\\s+", "").equalsIgnoreCase("back")) {
                System.out.println("Going back to Main Menu...");
                return null; // Exit to main menu
            }
            if (isUsernameTaken(username, users)) {
                System.out.println("Sorry, username already exists. Please try again.");
            } else {
                break; // Username available
            }
        }
        return username;
    }

    // Check if username is already taken
    private static boolean isUsernameTaken(String username, ArrayList<User> users) {
        // Check in-memory users
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true; // Username already taken in local list
            }
        }

        // Check database for username existence
        try (Connection conn = DatabaseConn.getConnection()) {
            String query = "SELECT username FROM students WHERE username = ? UNION SELECT username FROM teachers WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return true; // Username exists in database
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error checking username: " + e.getMessage());
        }

        return false; // Username not found
    }

    // Save user to the database
    private static boolean saveUserToDatabase(int role, String username, String password, String fullname, ArrayList<String> selectedSubjects) {
        try (Connection conn = DatabaseConn.getConnection()) {
            if (role == 1) {
                // Insert into students table
                String studentInsertQuery = "INSERT INTO students (username, password, full_name) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(studentInsertQuery)) {
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    stmt.setString(3, fullname);
                    stmt.executeUpdate();
                }

                // Insert subjects for student
                insertSubjectsForUser(username, selectedSubjects, conn, "student_subjects");
            } else if (role == 2) {
                // Insert into teachers table
                String teacherInsertQuery = "INSERT INTO teachers (username, password, full_name) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(teacherInsertQuery)) {
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    stmt.setString(3, fullname);
                    stmt.executeUpdate();
                }

                // Insert subjects for teacher
                insertSubjectsForUser(username, selectedSubjects, conn, "teacher_subjects");
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error during registration: " + e.getMessage());
            return false;
        }
    }

    // Subject selection method
    private static ArrayList<String> selectSubjects(Scanner scanner) {
        ArrayList<String> selectedSubjects = new ArrayList<>();
        while (true) {
            System.out.println("\nChoose your subjects (separate by commas for multiple choices):");
            System.out.println("\t(1) Math");
            System.out.println("\t(2) Science");
            System.out.println("\t(3) History");
            System.out.print("Enter numbers: ");
            String subjectChoices = scanner.nextLine();
            try {
                if (subjectCondition(subjectChoices, selectedSubjects)) {
                    break; // Valid subjects selected
                } else {
                    System.out.println("Invalid subject choice(s). Please enter valid numbers separated by commas.");
                    selectedSubjects.clear(); // Clear and ask again
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                selectedSubjects.clear(); // Clear and ask again
            }
        }
        return selectedSubjects;
    }

    // Validate and assign subjects
    private static boolean subjectCondition(String subjectChoices, ArrayList<String> selectedSubjects) {
        String[] choices = subjectChoices.split(",");
        boolean allValid = true;
        for (String choice : choices) {
            choice = choice.trim();
            if (choice.isEmpty() || !choice.matches("\\d+")) {
                allValid = false;
                continue;
            }
            switch (choice) {
                case "1":
                    selectedSubjects.add("Math");
                    break;
                case "2":
                    selectedSubjects.add("Science");
                    break;
                case "3":
                    selectedSubjects.add("History");
                    break;
                default:
                    allValid = false;
            }
        }
        return allValid && !selectedSubjects.isEmpty();
    }



    // Insert subjects for user into the respective table
    private static void insertSubjectsForUser(String username, ArrayList<String> selectedSubjects, Connection conn, String table) {
        String subjectInsertQuery;

        // Determine the correct username column based on the table name
        if (table.equals("student_subjects")) {
            subjectInsertQuery = "INSERT INTO " + table + " (student_username, subject_name) VALUES (?, ?)";
        } else if (table.equals("teacher_subjects")) {
            subjectInsertQuery = "INSERT INTO " + table + " (teacher_username, subject_name) VALUES (?, ?)";
        } else {
            System.out.println("Invalid table name.");
            return;
        }

        try (PreparedStatement stmt = conn.prepareStatement(subjectInsertQuery)) {
            for (String subject : selectedSubjects) {
                stmt.setString(1, username);
                stmt.setString(2, subject);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inserting subjects: " + e.getMessage());
        }
    }

    // Method to retrieve the list of subjects for a given user based on their role (student or teacher)
    public static ArrayList<String> getSubjects(String username, int role, Connection conn) throws SQLException {
        ArrayList<String> subjects = new ArrayList<>();
        try {
            String query = "";
            if (role == 1) { // Student
                query = "SELECT s.subject_name FROM subjects s " +
                        "JOIN student_subjects ss ON s.subject_name = ss.subject_name " +
                        "JOIN students st ON ss.student_username = st.username " +
                        "WHERE st.username = ?";
            } else if (role == 2) { // Teacher
                query = "SELECT s.subject_name FROM subjects s " +
                        "JOIN teacher_subjects ts ON s.subject_name = ts.subject_name " +
                        "JOIN teachers t ON ts.teacher_username = t.username " +
                        "WHERE t.username = ?";
            }

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        subjects.add(rs.getString("subject_name"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving subjects: " + e.getMessage());
        }
        return subjects;
    }
}
    