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
                scanner.nextLine(); // Consume newline

                if (role == 3) {
                    System.out.println("Going back to Main Menu......."); 
                    return; // Goes back to the previous menu
                } else if (role < 1 || role > 3) { // For invalid numbers thats nor within the choices
                    System.out.println("Invalid choice. Please type a number within the choices...");
                } else {
                    break; // Valid role choice, exit loop
                }
            } catch (InputMismatchException e) { 
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // ===================== SIGN IN DETAILS =======================================
        System.out.println("\n=========================================");
        System.out.println("\n\tLet's sign you up!");
        String username;

        while (true) {
            System.out.println("\n(type \"back\" now to go back to Main Menu.)");
            username = QuizUtils.getValidatedInput(scanner, "Enter username: "); // Uses a method that prevents the user to proceed with no typings

            if (isUsernameTaken(username, users)) { // Checks if username is already taken
                System.out.println("Sorry, username already exists. Please try again."); // if taken, will loop until username is accepted
            } else if (username.replaceAll("\\s+", "").equalsIgnoreCase("back")) { // transforms user input to lowercase and removes all whitespaces
                System.out.println("Going back to Main Menu.......");
                return; // Goes back to previous menu if user typed "back"
            } else {
                break; // Username available, exit loop
            }
        }
        
        String password = QuizUtils.getValidatedInput(scanner, "Enter password: "); // used a method so user will not proceed if there are no typings

        String fullname = QuizUtils.getValidatedInput(scanner, "Enter full name: ");// used a method so user will not proceed if there are no typings

        // Subject selection
        ArrayList<String> selectedSubjects = new ArrayList<>(); // arraylist for selected subject of the current user

        while (true) {
            System.out.println("\nChoose your number of subject(s) (you can select more than one by separating with commas):");
            System.out.println("\t(1) Math");
            System.out.println("\t(2) Science");
            System.out.println("\t(3) History");
            System.out.print("\nEnter the numbers corresponding to your subjects: ");
            
            String subjectChoices = scanner.nextLine(); // Stirng as input will may include comma if user selected > 1 subject
            
            try {
                if (subjectCondition(subjectChoices, selectedSubjects)) {
                    break; // Valid subjects selected, exit loop
                } else {
                    System.out.println("Invalid subject choice(s). Please enter valid numbers separated by commas.");
                    selectedSubjects.clear(); // Clear the list and ask again
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numbers only, separated by commas.");
                selectedSubjects.clear(); // Clear the list and ask again
            }
        }

        // Register user according to role
        registerToRole(role, username, password, fullname, selectedSubjects, users);
    }

    // Method for user login process
    public static void login(Scanner scanner, ArrayList<User> users) {
        System.out.println("\n=========================================");
        System.out.println("\nLet's Log you in! (type \"back\" to go back to Main Menu.)");
        
        String username;

        while (true) {
            username = QuizUtils.getValidatedInput(scanner, "\nEnter username: "); // used a method so user will not proceed if there are no typings

            // back option if user wants to go back to previous menu
            if (username.replaceAll("\\s+", "").equalsIgnoreCase("back")) { // checks if user typed "back" while also lowering its case and removing whitespaces
                System.out.println("Going back to Main Menu.......");
                return; // user typed "back", goes back to previous menu
            }
            break; // Valid username, proceed to passwowrd
        }

        String password = QuizUtils.getValidatedInput(scanner, "Enter password: "); // used a method so user will not proceed if there are no typings

        User user = findUser(username, password, users); // User (class), user (variable) = findUser (method that loops through the users arraylist to find a matched username and password that is currently typed in the within the login metjod)

        if (user != null) { //if user exists
            System.out.println("\n\t**** Login successful! ****");
            System.out.println("\n=========================================");

            switch (user.getRole()) { // gets the current user's role
                case "Student": // if user is student
                    StudentMenu.showMenu((Student) user, scanner); // directs the current user to the student menu
                    break;
                case "Teacher": // if user is teacher
                    TeacherMenu.showMenu((Teacher) user, scanner); // directs the current user to the teacher menu
                    break;
            }
        } else {
            System.out.println("Invalid username or password."); // username and password typed in the login method doesn't exist or doesn't match anything in the users arraylist
        }
    }

    // Helper method for subject validation and assignment
    public static boolean subjectCondition(String subjectChoices, ArrayList<String> selectedSubjects){
        String[] choices = subjectChoices.split(","); // gets the value of the subjectChoices, transform them into array, comma for spliting the item, and stores them at the "choices" variable
        boolean allValid = true; // assume all choices are valid

        for (String choice : choices) {
            choice = choice.trim(); // Removes spaces at both ends
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
                    allValid = false; // false if choices are invalid
                    System.out.println("Invalid choice: " + choice);
            }
        }
        return allValid; // return true if all choices are valid
    }

    // Register user to the selected role
    public static void registerToRole(int role, String username, String password, String fullname, ArrayList<String> selectedSubjects, ArrayList<User> users) {
        User user = null; // current user is null waiting to be assigned to a role
        switch (role) {
            case 1: // if user typed 1 in role assigning then, (student)
                user = new Student(username, password, fullname, selectedSubjects, 0);
                break;
            case 2: // if user typed 2 in role assigning then, (teacher)
                user = new Teacher(username, password, fullname, selectedSubjects);
                break;
        }

        if (user != null) { // when user is now assigned
            user.register(users); // registers the user to the designated role storage
            System.out.println("\n=============================================");
            System.out.println("||\t**** " + user.getRole() + " Registered! ****      ||");
            System.out.println("=============================================");
            user.displayRole(); // a method from the child class depending of the current user's role
        }
    }

    // Find user by username and password
    private static User findUser(String username, String password, ArrayList<User> users) {
        for (User user : users) { // iterates over the list of users in the User and temporarily stores them in the user variable
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) { // checks if there's a match
                return user; //there exists a registered user
            }
        }
        return null; // no such user is found
    }

    // Check if username is already taken
    private static boolean isUsernameTaken(String username, ArrayList<User> users) {
        for (User user : users) { // iterates
            if (user.getUsername().equals(username)) { // if theres already the same username existed in the User
                return true; // same username found
            }
        }
        return false; // no same username is found
    }
}
