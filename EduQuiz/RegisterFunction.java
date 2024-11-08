import java.util.Scanner;
import java.util.ArrayList;

public class RegisterFunction{


    public static void signUp(Scanner scanner, ArrayList<Admin> admins, ArrayList<Teacher> teachers, ArrayList<Student> students){
        System.out.println("New here? Then first, please select your role below:");
        System.out.println("(1) Student");
        System.out.println("(2) Teacher");
        System.out.println("(3) Admin");
        System.out.print("Enter the number for your role: ");
        int role = scanner.nextInt();
        scanner.nextLine();

        if (role == 3) {
            System.out.println("Hi Admin! Please login.");
            login(scanner);
            return;
        } else if (role < 1 || role > 3) {
            System.out.print("Invalid choice. please type a number within the choices... ");
            return;
        }

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (FileFunction.isUsernameExists(username)){
            System.out.print("Usernname already existed. Please try again...");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullname = scanner.nextLine();

        switch (role){
            case 1:
                    System.out.print("Enter subject : ");
                    String studentSubject = scanner.nextLine();
                    Student student = new Student(username, password, fullname, studentSubject);
                    students.add(student);
                    FileFunction.saveToFile("Student", student.username, student.password, student.fullname, student.subject);
                    System.out.println("Student registered!");
                    break;
                case 2:
                    System.out.print("Enter subject: ");
                    String teacherSubject  = scanner.nextLine();
                    Teacher teacher = new Teacher(username, password, fullname, teacherSubject);
                    teachers.add(teacher);
                    FileFunction.saveToFile("Teacher", teacher.username, teacher.password, teacher.fullname, teacher.subject);
                    System.out.println("Teacher Registered!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
    }

    public static void login(Scanner scanner) {
        System.out.println("Let's Log you in!");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Admin login successful!");
        }else{
            boolean isAuthenticated = FileFunction.readFile(username, password);

            if (isAuthenticated) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }
}