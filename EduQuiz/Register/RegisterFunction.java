package Register;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Users.Student;
import Users.Teacher;
import Users.User;

import Users.Menu.StudentMenu;
import Users.Menu.TeacherMenu;

import Quiz.QuizUtils;


public class RegisterFunction {

    // Method to handle user sign up process
    public static void signUp(Scanner scanner, ArrayList<User> users) {

        // ======================= ROLE SELECTION ======================================
        int role;
        while (true) {
            System.out.println("\n=========================================");
            System.out.println("\nNew here? Then first, please select your role below:");
            System.out.println("\t(1) Student");
            System.out.println("\t(2) Teacher");
            System.out.println("\t(3) Back");
            System.out.print("\nEnter choice: ");

            try {
                role = scanner.nextInt();
                scanner.nextLine(); 

                if (role == 3) {
                    System.out.println("Going back to Main Menu......."); 
                    return;
                } else if (role < 1 || role > 3) { 
                    System.out.println("Invalid choice. Please type a number within the choices...");
                } else {
                    break; 
                }
            } catch (InputMismatchException e) { 
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            }
        }

        // ===================== SIGN IN DETAILS =======================================
        System.out.println("\n=========================================");
        System.out.println("\n\tLet's sign you up!");
        String username;

            while (true) {
                System.out.println("\n(type \"back\" now to go back to Main Menu.)");
                username = QuizUtils.getEmptyInput(scanner, "Enter username: "); 

                if (isUsernameTaken(username, users)) { 
                    System.out.println("Sorry, username already exists. Please try again."); 
                } else if (username.replaceAll("\\s+", "").equalsIgnoreCase("back")) { 
                    System.out.println("Going back to Main Menu.......");
                    return; 
                } else {
                    break; 
                }
            }
        
        String password = QuizUtils.getEmptyInput(scanner, "Enter password: "); 

        String fullname = QuizUtils.getEmptyInput(scanner, "Enter full name: ");

         // ===================== SUBJECT SELECTION =======================================
        ArrayList<String> selectedSubjects = new ArrayList<>();

        while (true) {
            System.out.println("\nChoose your number of subject(s) (you can select more than one by separating a comma in between {e.g. 1,2}):");
            System.out.println("\t(1) Math");
            System.out.println("\t(2) Science");
            System.out.println("\t(3) History");
            System.out.print("\nEnter the numbers corresponding to your chosen subject/s: ");
            
            String subjectChoices = scanner.nextLine(); 
            
            try {
                if (subjectCondition(subjectChoices, selectedSubjects)) {
                    break; 
                } else {
                    System.out.println("Invalid subject choice(s). Please enter valid numbers separated by commas.");
                    selectedSubjects.clear();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numbers only, separated by commas.");
                selectedSubjects.clear(); 
            }
        }

        System.out.println("\n\nSelected subjects: " + selectedSubjects);
        
        // Register user according to role
        registerToRole(role, username, password, fullname, selectedSubjects, users);
    }

     // ===================== LOG IN METHOD =======================================
    public static void login(Scanner scanner, ArrayList<User> users) {
        System.out.println("\n=========================================");
        System.out.println("\nLet's Log you in! (type \"back\" to go back to Main Menu.)");
        
        String username;

        while (true) {
            username = QuizUtils.getEmptyInput(scanner, "\nEnter username: "); 
           
            if (username.replaceAll("\\s+", "").equalsIgnoreCase("back")) { 
                System.out.println("Going back to Main Menu.......");
                return;
            }
            break; 
        }

        String password = QuizUtils.getEmptyInput(scanner, "Enter password: "); 

        User user = findUser(username, password, users); 

        if (user != null) { 
            System.out.println("\n\t**** Login successful! ****");
            System.out.println("\n=========================================");

            switch (user.getRole()) { 
                case "Student": 
                    StudentMenu.showMenu((Student) user, scanner);
                    break;
                case "Teacher": 
                    TeacherMenu.showMenu((Teacher) user, scanner); 
                    break;
            }
        } else {
            System.out.println("Invalid username or password."); 
        }
    }

     // Helper method for subject validation and assignment
    public static boolean subjectCondition(String subjectChoices, ArrayList<String> selectedSubjects) {
        String[] choices = subjectChoices.split(",");
        ArrayList<String> usedChoices = new ArrayList<>();
        boolean allValid = true; 
    
        for (String choice : choices) {
            choice = choice.trim(); 
            if (choice.isEmpty() || !choice.matches("\\d+")) {
                allValid = false; 
                continue;
            }
    
            if (usedChoices.contains(choice)) {
                System.out.println("Sorry, duplicate input detected: " + choice);
                return false;
            }
    
            usedChoices.add(choice); 
    
            String subject = "";
            switch (choice) {
                case "1":
                    subject = "Math";
                    break;
                case "2":
                    subject = "Science";
                    break;
                case "3":
                    subject = "History";
                    break;
                default:
                    allValid = false; 
            }
    
            if (!subject.isEmpty()) {
                selectedSubjects.add(subject);
            }
        }
    
        return allValid && !selectedSubjects.isEmpty(); 
    }
    
    // Register user to the selected role
    public static void registerToRole(int role, String username, String password, String fullname, ArrayList<String> selectedSubjects, ArrayList<User> users) {
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
            user.register(users);
            System.out.println("\n=============================================");
            System.out.println("||\t**** " + user.getRole() + " Registered! ****      ||");
            System.out.println("=============================================");
            user.displayRole(); 
        }
    }

    // Find user by username and password
    private static User findUser(String username, String password, ArrayList<User> users) {
        for (User user : users) { 
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; 
    }

    // Check if username is already taken
    private static boolean isUsernameTaken(String username, ArrayList<User> users) {
        for (User user : users) { 
            if (user.getUsername().equals(username)) { 
                return true; 
            }
        }
        return false; 
    }
}
