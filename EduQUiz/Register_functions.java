import java.util.Scanner;
import java.util.ArrayList;

public class Register_functions{


    public static void signUp(Scanner scanner, ArrayList<Admin> admins, ArrayList<Teacher> teachers, ArrayList<Student> students){
        System.out.println("Welcome to EduQuiz! Please select your role below:");
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
        }

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();

        switch (role){
            case 1:
                    System.out.print("Enter subject : ");
                    String studentSubject = scanner.nextLine();
                    Student student = new Student(username, password, fullName, studentSubject);
                    students.add(student);
                    File_function.saveToFile(student.studentId, "Student", student.username, student.password, student.fullname, student.subject);
                    System.out.println("Student registered!");
                    break;
                case 2:
                    System.out.print("Enter subject: ");
                    String teacherSubject  = scanner.nextLine();
                    Teacher teacher = new Teacher(username, password, fullName, teacherSubject);
                    teachers.add(teacher);
                    File_function.saveToFile(teacher.teacherId,"Teacher", teacher.username, teacher.password, teacher.fullname, teacher.subject);
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
            boolean isAuthenticated = File_function.readFile(username, password);

            if (isAuthenticated) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }
}