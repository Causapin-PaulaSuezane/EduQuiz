import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);

        while(true){ 
            System.out.println("\n=========================================");
            System.out.println("\tHi! Welcome to EduQuiz!");
            System.out.println("\n\t1. Sign Up");
            System.out.println("\t2. Login");
            System.out.println("\t3. Exit");
            System.out.print("Enter choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    RegisterFunction.signUp(scanner, admins, teachers, students);
                    break;
                case 2:
                    RegisterFunction.login(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}