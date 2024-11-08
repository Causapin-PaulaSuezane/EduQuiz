import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class FileFunction {

    public static void saveToFile(String role, String username, String password, String fullname, String subject) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
            writer.write(", Role: " + role);
            writer.write(", Username: " + username);
            writer.write(", Password: " + password);
            writer.write(", Full Name: " + fullname);
            writer.write(", Subject: " + subject);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving to file.");
            e.printStackTrace();
        }
    }

    public static boolean readFile(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String storedUsername = "";
                String storedPassword = "";

                for (String part : parts) {
                    if (part.startsWith("Username: ")) {
                        storedUsername = part.substring("Username: ".length());
                    } else if (part.startsWith("Password: ")) {
                        storedPassword = part.substring("Password: ".length());
                    }
                }

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return true; 
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return false; 
    }

    public static boolean isUsernameExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", "); 
                for (String part : parts) {
                    if (part.startsWith("Username: ")){
                        String storedUsername = part.substring("Username: ".length());
                        if (storedUsername.equals(username)){
                            return true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while checking username: " + e.getMessage());
        }
        return false;
    }
}