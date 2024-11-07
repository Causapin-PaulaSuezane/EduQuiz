import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class File_function {
    public static void saveToFile(int nextId, String role, String username, String password, String fullname, String subject) {
        String ID = String.format("%04d", nextId);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
            writer.write("ID: " + ID);
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

                // Check if the stored username and password match the input
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
}