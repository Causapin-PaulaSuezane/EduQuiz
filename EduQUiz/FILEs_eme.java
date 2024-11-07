import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class FILEs_eme {
    public static void main(String[] args) {


     try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write("wieeeee");
        writer.write("\neme");
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    try{
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
